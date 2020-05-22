public class AutocompleteJComboBox extends JComboBox{
    static final long serialVersionUID = 4321421L;
    private final Searchable<String,String> searchable;

    public AutocompleteJComboBox(Searchable<String,String> s){
        super();
        this.searchable = s;
        setEditable(true);
        Component c = getEditor().getEditorComponent();

        if ( c instanceof JTextComponent ){
            final JTextComponent tc = (JTextComponent)c;
            tc.getDocument().addDocumentListener(new DocumentListener(){

                @Override
                public void changedUpdate(DocumentEvent arg0) {}

                @Override
                public void insertUpdate(DocumentEvent arg0) {
                    update();
                }

                @Override
                public void removeUpdate(DocumentEvent arg0) {
                    update();
                }

                public void update(){
                    SwingUtilities.invokeLater(new Runnable(){

                        @Override
                        public void run() {
                            List<String> founds = new ArrayList<String>(searchable.search(tc.getText()));
                            Set<String> foundSet = new HashSet<String>();
                            for ( String s : founds ){
                                foundSet.add(s.toLowerCase());
                            }
                            Collections.sort(founds);//sort alphabetically
                            setEditable(false);
                            removeAllItems();
                            //if founds contains the search text, then only add once.

                            if ( !foundSet.contains( tc.getText().toLowerCase()) ){
                                addItem( tc.getText() );
                            }                           

                            for (String s : founds) {
                                addItem(s);
                            }
                            setEditable(true);
                            setPopupVisible(true);
                        }
                    });
                }
            });

            tc.addFocusListener(new FocusListener(){

                @Override
                public void focusGained(FocusEvent arg0) {
                    if ( tc.getText().length() > 0 ){
                        setPopupVisible(true);
                    }
                }

                @Override
                public void focusLost(FocusEvent arg0) {                        
                }
            });
        }else{
            throw new IllegalStateException("Editing component is not a JTextComponent!");
        }
    }
}