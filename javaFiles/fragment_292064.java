public class NoteList extends JList {
    ...
    public class NoteListModel extends AbstractListModel {
        ...
        public < T extends AbstractNoteItem > NotePanel < T > getPanelFromIndex(int index) {
            if (!indexExists(index)) {
                // FYI, indexExists(int) works fine
                return null;
            } else {
                T item = ( T ) ( getElementAt(index) ) ; // this should generate a warning
                // FYI, getElementAt(int) works fine
                assert (item != null);  
                // not needed // Class<?> itemClass = item.getClass();
                return (new NotePanel<T> (item));
            }
        }
    } }