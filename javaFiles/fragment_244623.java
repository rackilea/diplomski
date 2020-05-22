if (selected)
    {
      super.setBackground(getBackgroundSelectionColor());
      setForeground(getTextSelectionColor());

      if (hasFocus)
        setBorderSelectionColor(UIManager.getLookAndFeelDefaults().
                                getColor("Tree.selectionBorderColor"));
      else
        setBorderSelectionColor(null);
    }
  else
    {
      super.setBackground(getBackgroundNonSelectionColor());
      setForeground(getTextNonSelectionColor());
      setBorderSelectionColor(null);
    }