// the custom RowFilter
public class ContactRowFilter extends RowFilter {
    private String compare;

    public ContactRowFilter(String compare) {
        this.compare = compare;
    }

    public boolean include(Entry entry) {
        Contact contact = (Contact) entry.getValue(0);
        return contact.getName().contains(compare);
    }
}

// custom documentListener
public class SearchFieldListener implements DocumentListener {
    private JXList list;

    public SearchFieldListener(JXList list) {
        this.list = list;
    }

    @Override
    public void insertUpdate(...) {
        updateFilter(evt.getDocument());
    }
    ....
    protected void updateFilter(Document doc) {
        String text = doc.getText(0, doc.getLength());
        list.setRowFilter(text.length > 0 ?
            new ContactRowFilter(text) : null);
    }

}

// usage
JXList list = new JXList(myModel);
list.setAutoCreateRowSorter(true);
DocumentListener listener = new SearchFieldListener(list);
JTextField searchField = new JTextField(20);
searchField.getDocument().addDocumentListener(listener);