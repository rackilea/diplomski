import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.SortedList;
import ca.odell.glazedlists.swing.AutoCompleteSupport;
import ca.odell.glazedlists.swing.EventComboBoxModel;
import ca.odell.glazedlists.swing.EventListModel;
import ca.odell.glazedlists.swing.EventSelectionModel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author Andrew Roberts
 */
public class GlazedListsAutocompleteTest {

    private JFrame mainFrame;
    private JComboBox availableItems;
    private EventList<Book> books = new BasicEventList<Book>();
    private EventList<Book> selectedBooks;

    public GlazedListsAutocompleteTest() {
        populateAvailableBooks();
        createGui();
        mainFrame.setVisible(true);
    }

    private void populateAvailableBooks() {
        books.add(new Book("A Tale of Two Cities"));
        books.add(new Book("The Lord of the Rings"));
        books.add(new Book("The Hobbit"));
        books.add(new Book("And Then There Were None"));
    }

    private void createGui() {

        mainFrame = new JFrame("GlazedLists Autocomplete Example");
        mainFrame.setSize(600, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //EventComboBoxModel<Book> comboModel = new EventComboBoxModel<Book>(books);
        availableItems = new JComboBox();
        final SortedList<Book> availableBooks = new SortedList<Book>((BasicEventList<Book>) GlazedLists.eventList(books), new BookComparitor());

        selectedBooks = new SortedList<Book>(new BasicEventList<Book>(), new BookComparitor());

        AutoCompleteSupport autocomplete = AutoCompleteSupport.install(availableItems, availableBooks);

        JButton addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                EventComboBoxModel<Book> comboModel = (EventComboBoxModel<Book>) availableItems.getModel();
                try {
                    Book book = (Book) comboModel.getSelectedItem();
                    selectedBooks.add(book);
                    availableBooks.remove(book);
                } catch (ClassCastException ex) {
                    System.err.println("Invalid item: cannot be added.");
                }

            }
        });

        final EventListModel listModel = new EventListModel(selectedBooks);
        final EventSelectionModel selectionModel = new EventSelectionModel(selectedBooks);

        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                EventList<Book> selectedListItems = selectionModel.getSelected();
                for (Book book : selectedListItems) {
                    selectedBooks.remove(book);
                    availableBooks.add(book);
                }
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(availableItems, BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.EAST);


        JList selectedItemsList = new JList(listModel);
        selectedItemsList.setSelectionModel(selectionModel);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.getContentPane().add(panel, BorderLayout.NORTH);
        mainFrame.getContentPane().add(selectedItemsList, BorderLayout.CENTER);
        mainFrame.getContentPane().add(removeButton, BorderLayout.SOUTH);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
          new GlazedListsAutocompleteTest();
        }
    });
    }

    class Book {
        private String title;

        public Book() {
        }

        public Book(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return getTitle();
        }   
    }

    class BookComparitor implements Comparator<Book> {

        @Override
        public int compare(Book b1, Book b2) {
            return b1.getTitle().compareToIgnoreCase(b2.getTitle());
        }
    }
}