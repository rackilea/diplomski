public class ExclusiveBooleanEditor extends AbstractCellEditor implements TableCellEditor,
    TreeCellEditor {

  //
  // Instance Variables
  //

  /** The Swing component being edited. */
  protected JComponent editorComponent;
  /**
   * The delegate class which handles all methods sent from the <code>CellEditor</code>.
   */
  protected EditorDelegate delegate;
  /**
   * An integer specifying the number of clicks needed to start editing. Even if
   * <code>clickCountToStart</code> is defined as zero, it will not initiate until a click occurs.
   */
  protected int clickCountToStart = 1;

  //
  // Constructors
  //

  public ExclusiveBooleanEditor() {
    this(new JRadioButton());
    JRadioButton radioButton = (JRadioButton) getComponent();
    radioButton.setHorizontalAlignment(JRadioButton.CENTER);
  }

  public ExclusiveBooleanEditor(final JRadioButton radioButton) {
    editorComponent = radioButton;
    delegate = new EditorDelegate() {
      // FIXME replace
      @Override
      public void setValue(Object value) {
        boolean selected = false;
        if (value instanceof Boolean) {
          selected = ((Boolean) value).booleanValue();
        } else if (value instanceof String) {
          selected = value.equals("true");
        }
        radioButton.setSelected(selected);
      }

      @Override
      public Object getCellEditorValue() {
        return Boolean.valueOf(radioButton.isSelected());
      }
    };
    radioButton.addActionListener(delegate);
    radioButton.setRequestFocusEnabled(false);
  }

  /**
   * Returns a reference to the editor component.
   *
   * @return the editor <code>Component</code>
   */
  public Component getComponent() {
    return editorComponent;
  }

  //
  // Modifying
  //

  /**
   * Specifies the number of clicks needed to start editing.
   *
   * @param count an int specifying the number of clicks needed to start editing
   * @see #getClickCountToStart
   */
  public void setClickCountToStart(int count) {
    clickCountToStart = count;
  }

  /**
   * Returns the number of clicks needed to start editing.
   * 
   * @return the number of clicks needed to start editing
   */
  public int getClickCountToStart() {
    return clickCountToStart;
  }

  //
  // Override the implementations of the superclass, forwarding all methods
  // from the CellEditor interface to our delegate.
  //

  /**
   * Forwards the message from the <code>CellEditor</code> to the <code>delegate</code>.
   * 
   * @see EditorDelegate#getCellEditorValue
   */
  @Override
  public Object getCellEditorValue() {
    return delegate.getCellEditorValue();
  }

  /**
   * Forwards the message from the <code>CellEditor</code> to the <code>delegate</code>.
   * 
   * @see EditorDelegate#isCellEditable(EventObject)
   */
  @Override
  public boolean isCellEditable(EventObject anEvent) {
    return delegate.isCellEditable(anEvent);
  }

  /**
   * Forwards the message from the <code>CellEditor</code> to the <code>delegate</code>.
   * 
   * @see EditorDelegate#shouldSelectCell(EventObject)
   */
  @Override
  public boolean shouldSelectCell(EventObject anEvent) {
    return delegate.shouldSelectCell(anEvent);
  }

  /**
   * Forwards the message from the <code>CellEditor</code> to the <code>delegate</code>.
   * 
   * @see EditorDelegate#stopCellEditing
   */
  @Override
  public boolean stopCellEditing() {
    return delegate.stopCellEditing();
  }

  /**
   * Forwards the message from the <code>CellEditor</code> to the <code>delegate</code>.
   * 
   * @see EditorDelegate#cancelCellEditing
   */
  @Override
  public void cancelCellEditing() {
    delegate.cancelCellEditing();
  }

  //
  // Implementing the TreeCellEditor Interface
  //

  /** Implements the <code>TreeCellEditor</code> interface. */
  @Override
  public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected,
      boolean expanded, boolean leaf, int row) {
    String stringValue = tree.convertValueToText(value, isSelected, expanded, leaf, row, false);

    delegate.setValue(stringValue);
    return editorComponent;
  }

  //
  // Implementing the CellEditor Interface
  //
  /** Implements the <code>TableCellEditor</code> interface. */
  @Override
  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
      int row, int column) {
    delegate.setValue(value);
    if ((editorComponent instanceof JCheckBox) || (editorComponent instanceof JRadioButton)) {
      // in order to avoid a "flashing" effect when clicking a checkbox
      // in a table, it is important for the editor to have as a border
      // the same border that the renderer has, and have as the background
      // the same color as the renderer has. This is primarily only
      // needed for JCheckBox since this editor doesn't fill all the
      // visual space of the table cell, unlike a text field.
      TableCellRenderer renderer = table.getCellRenderer(row, column);
      Component c =
          renderer.getTableCellRendererComponent(table, value, isSelected, true, row, column);
      if (c != null) {
        editorComponent.setOpaque(true);
        editorComponent.setBackground(c.getBackground());
        if (c instanceof JComponent) {
          editorComponent.setBorder(((JComponent) c).getBorder());
        }
      } else {
        editorComponent.setOpaque(false);
      }
    }
    return editorComponent;
  }


  //
  // Protected EditorDelegate class
  //

  /**
   * The protected <code>EditorDelegate</code> class.
   */
  protected class EditorDelegate implements ActionListener, ItemListener, Serializable {

    /** The value of this cell. */
    protected Object value;

    /**
     * Returns the value of this cell.
     * 
     * @return the value of this cell
     */
    public Object getCellEditorValue() {
      return value;
    }

    /**
     * Sets the value of this cell.
     * 
     * @param value the new value of this cell
     */
    public void setValue(Object value) {
      this.value = value;
    }

    /**
     * Returns true if <code>anEvent</code> is <b>not</b> a <code>MouseEvent</code>. Otherwise, it
     * returns true if the necessary number of clicks have occurred, and returns false otherwise.
     *
     * @param anEvent the event
     * @return true if cell is ready for editing, false otherwise
     * @see #setClickCountToStart
     * @see #shouldSelectCell
     */
    public boolean isCellEditable(EventObject anEvent) {
      if (anEvent instanceof MouseEvent) {
        return ((MouseEvent) anEvent).getClickCount() >= clickCountToStart;
      }
      return true;
    }

    /**
     * Returns true to indicate that the editing cell may be selected.
     *
     * @param anEvent the event
     * @return true
     * @see #isCellEditable
     */
    public boolean shouldSelectCell(EventObject anEvent) {
      return true;
    }

    /**
     * Returns true to indicate that editing has begun.
     *
     * @param anEvent the event
     */
    public boolean startCellEditing(EventObject anEvent) {
      return true;
    }

    /**
     * Stops editing and returns true to indicate that editing has stopped. This method calls
     * <code>fireEditingStopped</code>.
     *
     * @return true
     */
    public boolean stopCellEditing() {
      fireEditingStopped();
      return true;
    }

    /**
     * Cancels editing. This method calls <code>fireEditingCanceled</code>.
     */
    public void cancelCellEditing() {
      fireEditingCanceled();
    }

    /**
     * When an action is performed, editing is ended.
     * 
     * @param e the action event
     * @see #stopCellEditing
     */
    @Override
    public void actionPerformed(ActionEvent e) {
      ExclusiveBooleanEditor.this.stopCellEditing();
    }

    /**
     * When an item's state changes, editing is ended.
     * 
     * @param e the action event
     * @see #stopCellEditing
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
      ExclusiveBooleanEditor.this.stopCellEditing();
    }
  }

  public static class ExclusiveBooleanRenderer extends JRadioButton implements TableCellRenderer,
      UIResource {
    private static final Border noFocusBorder = new EmptyBorder(1, 1, 1, 1);
    private static final JLabel emptyLabel = new JLabel("");

    public ExclusiveBooleanRenderer() {
      super();
      setHorizontalAlignment(JRadioButton.CENTER);
      setBorderPainted(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int column) {

      // Don't draw if it is not changeable
      if (value == null) {
        if (isSelected) {
          emptyLabel.setForeground(table.getSelectionForeground());
          emptyLabel.setBackground(table.getSelectionBackground());
        } else {
          emptyLabel.setForeground(table.getForeground());
          emptyLabel.setBackground(table.getBackground());
        }

        return emptyLabel;
      }
      if (isSelected) {
        setForeground(table.getSelectionForeground());
        super.setBackground(table.getSelectionBackground());
      } else {
        setForeground(table.getForeground());
        setBackground(table.getBackground());
      }
      setSelected((value != null && ((Boolean) value).booleanValue()));

      if (hasFocus) {
        setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
      } else {
        setBorder(noFocusBorder);
      }

      return this;
    }
  }

} // End of class JCellEditor