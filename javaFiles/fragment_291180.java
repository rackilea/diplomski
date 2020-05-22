public class MainMenu extends JPanel
{

private final Connection connection;

private final Application application;


private JTextField word = new JTextField(10);

private final JButton translate = new JButton();

private final JComboBox translators = new JComboBox();

private final JButton search = new JButton();
private JList speechPartAndDefinitionWidget;

private final DefaultListModel speechPartAndDefinitionWidgetModel = new DefaultListModel();

private Translator translator;
private Suggestor suggestor;

private DefaultListModel translatedWidgetModel;
private JList translatedWidget;

private final DefaultListModel suggestionWidgetModel = new DefaultListModel();
private final JList suggestionWidget = new JList(suggestionWidgetModel);

private JavaWindow javaWindow = new JavaWindow(suggestionWidget);

public MainMenu(Application application, Connection connection)
{

    word.getDocument().addDocumentListener(new DocumentListener()
    {
        public void insertUpdate(DocumentEvent e)
        {
            try
            {
                onWordUpdated(word.getText());
            }
            catch (ClassNotFoundException e1)
            {
                e1.printStackTrace();
            }
            catch (SQLException e1)
            {
                e1.printStackTrace();
            }
        }

        public void removeUpdate(DocumentEvent e)
        {
            try
            {
                onWordUpdated(word.getText());
            }
            catch (ClassNotFoundException e1)
            {
                e1.printStackTrace();
            }
            catch (SQLException e1)
            {
                e1.printStackTrace();
            }
        }

        public void changedUpdate(DocumentEvent e)
        {
            try
            {
                onWordUpdated(word.getText());
            }
            catch (ClassNotFoundException e1)
            {
                e1.printStackTrace();

            }
            catch (SQLException e1)
            {
                e1.printStackTrace();

            }
        }
    });


    this.application = application;
    this.connection = connection;

    translators.setFocusable(false);
    word.grabFocus();
    word.requestFocus();
    word.setFocusable(true);

    search.setText("<html><b><u>S</u>earch</b></html>");
    translate.setText("<html><b><u>T</u>ranslate</b></html>");

    translators.addItem(new EnglishBisayaTranslator(connection));
    setToolTipText("English-Bisaya");
    translators.addItem(new BisayaEnglishTranslator(connection));
    setToolTipText("Bisaya-English");

    setLayout(new BorderLayout());
    JPanel formX = new JPanel();
    formX.setLayout(new BorderLayout());

    JPanel header = new JPanel();
    header.setLayout(new GridBagLayout());
    header.add(translators);
    header.add(word);
    header.add(search);
    header.add(translate);

    translators.setBorder(BorderFactory.createEtchedBorder(1));
    translators.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
    word.setBorder(BorderFactory.createEtchedBorder());
    word.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
    word.setFont(new Font("Garamond", Font.BOLD, 17));
    suggestionWidget.setFont(new Font("Calibri", Font.BOLD, 17));
    header.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 8));


    formX.add(BorderLayout.PAGE_START, header);
    formX.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 10));
    add(header, BorderLayout.NORTH);

    speechPartAndDefinitionWidget = new JList(speechPartAndDefinitionWidgetModel);
   speechPartAndDefinitionWidget.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    speechPartAndDefinitionWidget.addListSelectionListener(new ListSelectionListener()
    {
        public void valueChanged(ListSelectionEvent ev)
        {
            onDefinitionSelected(ev);
        }
    });

    JPanel formBottom = new JPanel();
    formBottom.setLayout(new GridBagLayout());
    add(formBottom, BorderLayout.CENTER);
    Component up = new JScrollPane(speechPartAndDefinitionWidget);
    formBottom.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));   speechPartAndDefinitionWidget.setBorder(BorderFactory.createLineBorder(Color.black,1));

    JPanel down = new JPanel();
    down.setLayout(new BorderLayout());
    down.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    down.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


    down.add(translatedWidget = new JList(translatedWidgetModel = new DefaultListModel()));
    add(down, BorderLayout.CENTER);
    translatedWidget.setBorder(BorderFactory.createLineBorder(Color.black, 1));
    translatedWidget.setFont(new Font("Calibri",Font.BOLD, 17));
     speechPartAndDefinitionWidget.setFont(new Font("Calibri", Font.BOLD, 17));
    add(BorderLayout.CENTER, new JSplitPane(JSplitPane.VERTICAL_SPLIT, up, down));

    word.addKeyListener(new KeyAdapter()
    {
        public void keyPressed(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            {
                hideSuggestionWindowToBack();
            }
            else if (e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                int selectedIndex = suggestionWidget.getSelectedIndex();

                if (selectedIndex == -1)
                {
                    onSearchClick();
                }
                else
                {
                    onSuggestionSelected(selectedIndex);

                }
            }
        }

        public void keyReleased(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                hideSuggestionWindowToBack();
                onSearchClick();
            }
        }
    });

    translators.addActionListener(new

            ActionListener()
            {
                public void actionPerformed
                        (ActionEvent e)
                {
                    onTranslatorsClick();
                }
            }

    );

    word.addKeyListener(new

            KeyAdapter()
            {
                public void keyPressed
                        (KeyEvent
                                 e)
                {
                    if (suggestionWidgetModel.isEmpty())
                    {
                        return;
                    }

                    if (e.getKeyCode() == KeyEvent.VK_DOWN)
                    {
                        final Point location = word.getLocationOnScreen();
                        javaWindow.setLocation(location.x, location.y + word.getHeight());
                        showSuggestionWindowToBack();

                        int currentSelectedItemIndex = suggestionWidget.getSelectedIndex();
                        if (currentSelectedItemIndex == -1 || currentSelectedItemIndex == suggestionWidgetModel.size() - 1)
                        {
                            suggestionWidget.setSelectedIndex(0);

                        }
                        else if (currentSelectedItemIndex < suggestionWidgetModel.size() - 1)
                        {
                            suggestionWidget.setSelectedIndex(currentSelectedItemIndex + 1);
                        }
                    }
                    else if (e.getKeyCode() == KeyEvent.VK_UP)
                    {
                        int currentSelectedItemIndex = suggestionWidget.getSelectedIndex();
                        if (currentSelectedItemIndex == -1 || currentSelectedItemIndex == suggestionWidgetModel.size() + 1)
                        {
                            suggestionWidget.setSelectedIndex(0);
                        }
                        else if (currentSelectedItemIndex < suggestionWidgetModel.size() + 1)
                        {
                            suggestionWidget.setSelectedIndex(currentSelectedItemIndex - 1);

                        }
                    }
                }

            }
    );


    suggestionWidget.addMouseListener(new MouseAdapter()
    {
        @Override
        public void mousePressed(MouseEvent e)
        {
            int selectedIndex = suggestionWidget.getSelectedIndex();

            if (e.getClickCount() == 2)
            {
                if (selectedIndex < -1)
                {
                    onSearchClick();
                }
                else
                {
                    onSuggestionSelected(selectedIndex);
                    hideSuggestionWindowToBack();
                }
            }

        }

        public void mouseReleased(MouseEvent e)
        {
            if (e.getClickCount() == 2)
            {
                {
                    hideSuggestionWindowToBack();
                }
            }
        }
    });

    speechPartAndDefinitionWidget.addKeyListener(new

            KeyAdapter()
            {
                @Override
                public void keyPressed
                        (KeyEvent
                                 e)
                {
                    if (speechPartAndDefinitionWidgetModel.isEmpty())
                    {
                        return;
                    }

                    if (e.getKeyCode() == KeyEvent.VK_DOWN)
                    {

                        int currentSelectedItemIndex = speechPartAndDefinitionWidget.getSelectedIndex();
                        if (currentSelectedItemIndex == -1 || currentSelectedItemIndex == speechPartAndDefinitionWidgetModel.size() - 1)
                        {
                            speechPartAndDefinitionWidget.setSelectedIndex(0);

                        }
                        else if (currentSelectedItemIndex < speechPartAndDefinitionWidgetModel.size() - 1)
                        {
                            speechPartAndDefinitionWidget.setSelectedIndex(currentSelectedItemIndex + 1);
                            onTranslate();
                        }
                    }
                    else if (e.getKeyCode() == KeyEvent.VK_UP)
                    {
                        int currentSelectedItemIndex = speechPartAndDefinitionWidget.getSelectedIndex();
                        if (currentSelectedItemIndex == -1 || currentSelectedItemIndex == speechPartAndDefinitionWidgetModel.size() + 1)
                        {
                            speechPartAndDefinitionWidget.setSelectedIndex(0);
                        }
                        else if (currentSelectedItemIndex < speechPartAndDefinitionWidgetModel.size() + 1)
                        {
                            speechPartAndDefinitionWidget.setSelectedIndex(currentSelectedItemIndex - 1);
                        }
                    }

                }
            }
    );

    speechPartAndDefinitionWidget.addMouseMotionListener(new MouseMotionAdapter()
    {
        @Override
        public void mouseMoved(MouseEvent e)
        {
            final int x = e.getX();
            final int y = e.getY();


            final Rectangle cellBounds = speechPartAndDefinitionWidget.getCellBounds(0, speechPartAndDefinitionWidget.getModel().getSize() - 1);
            if (cellBounds != null && cellBounds.contains(x, y))
            {
                speechPartAndDefinitionWidget.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            else
            {
                speechPartAndDefinitionWidget.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
    }
    );

    speechPartAndDefinitionWidget.setCellRenderer(new

            DefaultListCellRenderer()
            {
                @Override
                public Component getListCellRendererComponent
                        (JList
                                 list, Object
                                value, int index,
                         boolean isSelected,
                         boolean cellHasFocus)
                {
                    final String speechPart = ((DefinitionUiModel) value).getPart().getFriendlyName();
                    final String definition = ((DefinitionUiModel) value).getDefinition().toString();
                    Color bg = null;
                    Color fg = null;

                    final JLabel renderer = new JLabel(
                            "<html><font color=red>" + speechPart + "</font>) => <font color=black>" + definition + "</font></html>");
                    if (renderer.isEnabled())
                    {

                        if (isSelected)
                        {
                            renderer.setText("<html><font color=gray>" + speechPart + "</font><font color=blue><u><b>" + definition + "</b></u></font></html>");
                            renderer.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        }

                        JList.DropLocation dropLocation = list.getDropLocation();
                        if (dropLocation != null
                                && !dropLocation.isInsert()
                                && dropLocation.getIndex() == index)
                        {

                            bg = DefaultLookup.getColor(this, ui, "List.dropCellBackground");
                            fg = DefaultLookup.getColor(this, ui, "List.dropCellForeground");

                            isSelected = true;
                        }

                        if (isSelected)
                        {
                            renderer.setBackground(bg == null ? list.getSelectionBackground() : bg);
                            renderer.setForeground(fg == null ? list.getSelectionForeground() : fg);
                        }

                        Border border = null;

                        if (cellHasFocus)
                        {

                            if (isSelected)
                            {
                                border = DefaultLookup.getBorder(this, ui, "List.focusSelectedCellHighlightBorder");
                            }
                            if (border == null)
                            {
                                border = DefaultLookup.getBorder(this, ui, "List.focusCellHighlightBorder");
                            }
                        }

                        else
                        {

                        }


                    }
                    return renderer;
                }
            }

    );


    translatedWidget.setForeground(Color.black);

    translate.addActionListener(new

            ActionListener()
            {
                public void actionPerformed
                        (ActionEvent
                                 e)
                {
                    onTranslate();
                }
            }

    );
    search.setToolTipText("find");
    search.addActionListener(new

            ActionListener()
            {
                public void actionPerformed
                        (ActionEvent
                                 e)
                {
                    onSearchClick();

                }

            }

    );
    translators.setSelectedIndex(0);

    suggestionWidget.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

    onTranslatorsClick();

}

private void onSuggestionSelected(int selectedIndex)
{
    String hold = (String) suggestionWidgetModel.getElementAt(selectedIndex);
    word.setText(hold);
    hideSuggestionWindowToBack();
    suggestionWidgetModel.clear();


    if (javaWindow == null)
    {
        javaWindow.dispose();
        javaWindow = null;

    }


}

public void onWordUpdated(final String toComplete) throws ClassNotFoundException, SQLException
{
    new Thread(new Runnable()
    {
        public void run()
        {
            try
            {
                final List<Suggestion> suggestions = suggestor.getSuggestions(toComplete);

                SwingUtilities.invokeLater(new Runnable()
                {
                    public void run()
                    {
                        speechPartAndDefinitionWidgetModel.clear();
                        translatedWidgetModel.clear();
                        suggestionWidgetModel.clear();
                        try
                        {
                            for (Suggestion suggestion : suggestions)
                            {
                                suggestionWidgetModel.addElement(suggestion.getCaption());
                            }
                            if (!suggestions.isEmpty())
                            {
                                suggestionWidget.setSelectedIndex(0);

                                if (javaWindow == null)
                                {
                                    javaWindow = new JavaWindow(suggestionWidget);
                                }
                                else
                                {
                                    final Point location = word.getLocationOnScreen();
                                    javaWindow.setLocation(location.x, location.y + word.getHeight());
                                }
                                showSuggestionWindowToBack();
                            }
                            else
                            {
                                hideSuggestionWindowToBack();
                            }
                        }
                        catch (Exception exception)
                        {
                            exception.printStackTrace();
                        }
                    }
                });
            }
            catch (SQLException e)

            {
                onSqlError(e);
            }
        }
    }
            , "onWordUpdated").

            start();

}

private void onTranslate()
{
    try
    {
        translatedWidgetModel.clear();

        String lookupWord = word.getText();
        if (lookupWord != null)
        {
            Collection<String> bisayaWords = this.translator.translateSimple(lookupWord);

            for (String bisayaWord : bisayaWords)
            {
                translatedWidgetModel.addElement(bisayaWord.toUpperCase());

            }
        }
    }
    catch (SQLException ex)
    {
        onSqlError(ex);
    }
}

private void onSqlError(SQLException ex)
{
    JOptionPane.showMessageDialog(null, "SQL Error! :" + ex.getMessage());
}


private void onDefinitionSelected(ListSelectionEvent ev)
{
    if (!ev.getValueIsAdjusting())
    {
        int selectedIndex = speechPartAndDefinitionWidget.getSelectedIndex();

        if (selectedIndex != -1)
        {
            final DefinitionUiModel definitionUiModel = (DefinitionUiModel) speechPartAndDefinitionWidgetModel.get(selectedIndex);
            translate(definitionUiModel.getDefinition());
        }
    }
}

private void translate(Definition definition)
{
    try
    {
        translatedWidgetModel.clear();

        Map<String, String> map = new HashMap<String, String>();
        int definitionId = definition.getId();
        String definitionName = definition.getValue();


        int nameId = translator.getFromDictionary().getNameIdForDefinitionId(definitionId);

        if (nameId > -1)
        {
            final Collection<String> translation = translator.translateSimple(nameId);
            for (String transWord : translation)
            {
                map.put(transWord, definitionName);

                for (Map.Entry<String, String> entry : map.entrySet())
                {

                    String myValue = entry.getKey().toUpperCase() + " -- " + entry.getValue();
                    translatedWidgetModel.addElement(myValue);
                }
            }
        }
    }
    catch (SQLException ex)
    {
        onSqlError(ex);
    }
}


private void onSearchClick()
{
    search.setEnabled(true);
    hideSuggestionWindowToBack();
    speechPartAndDefinitionWidgetModel.clear();
    translatedWidgetModel.clear();

    try
    {
        final String lookupWord = word.getText();

        if (lookupWord != null)
        {
            final Dictionary fromDictionary = translator.getFromDictionary();

            final WordDefinitions definitions = fromDictionary.getWordDefinitions(lookupWord);

            final Iterator<Map.Entry<SpeechPart, List<Definition>>> items = definitions.iterator();

            while (items.hasNext())
            {
                final Map.Entry<SpeechPart, List<Definition>> item = items.next();

                for (Definition definition : item.getValue())
                {
                    speechPartAndDefinitionWidgetModel.addElement(new DefinitionUiModel(item.getKey(), definition));
                }
            }
        }
    }
    catch (SQLException ex)
    {
        onSqlError(ex);
    }
}

private void onTranslatorsClick()
{
    translator = (Translator) translators.getSelectedItem();
    suggestor = new Suggestor(translator.getFromDictionary(), 10);
    word.setEnabled(true);

    application.setTitle(translator.toString());

    translators.setToolTipText("tooltip : " + translator.toString());

    speechPartAndDefinitionWidgetModel.clear();
}

private void hideSuggestionWindowToBack()
{
    if (javaWindow == null)
    {
        return;
    }

    javaWindow.setVisible(false);
    javaWindow.toBack();
}

private void showSuggestionWindowToBack()
{
    if (javaWindow == null)
    {
        return;
    }

    javaWindow.setVisible(true);
    javaWindow.toFront();
}

}