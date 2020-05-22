import java.awt.Component;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;


public class Browser extends JFrame {


    private JTree tree;
    //ManagerOfContacts mngrOfContacts;

    public Browser() {

        //Generates the ManagerOfContacts and associated Contacts
        //Driver driver = new Driver();
        //mngrOfContacts = driver.getManagerOfContacts();
        //---------------------------\\


        DefaultMutableTreeNode contacts = new DefaultMutableTreeNode("Contacts");
        createNodes(contacts);
        tree = new JTree(contacts);

        // use your own renderer (!)
        tree.setCellRenderer(new MyTreeCellRenderer());

        JScrollPane treeView = new JScrollPane(tree);

        add(treeView);

        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public final void createNodes(DefaultMutableTreeNode top){
        DefaultMutableTreeNode contactName;

        // dummies
        List<Contact> contacts = new ArrayList<Contact>();
        contacts.add(new Contact("Me", true));
        contacts.add(new Contact("You"));

        Iterator<Contact> contactItr = contacts.iterator();
        while(contactItr.hasNext()){
            contactName = new DefaultMutableTreeNode(contactItr.next());
            top.add(contactName);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Browser browsr = new Browser();
            }
        });

    }

    // dummy
    private static class Contact {

        private boolean someProperty;
        private String name;

        public Contact(String name) {
            this(name, false);
        }

        public Contact(String name, boolean property) {
            this.someProperty = property;
            this.name = name;
        }

        public boolean isSomeProperty() {
            return someProperty;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    // this is what you want
    private static class MyTreeCellRenderer extends DefaultTreeCellRenderer {

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

            // decide what icons you want by examining the node
            if (value instanceof DefaultMutableTreeNode) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
                if (node.getUserObject() instanceof String) {
                    // your root node, since you just put a String as a user obj                    
                    setIcon(UIManager.getIcon("FileView.computerIcon"));
                } else if (node.getUserObject() instanceof Contact) {
                    // decide based on some property of your Contact obj
                    Contact contact = (Contact)  node.getUserObject();
                    if (contact.isSomeProperty()) {
                        setIcon(UIManager.getIcon("FileView.hardDriveIcon"));
                    } else {
                        setIcon(UIManager.getIcon("FileChooser.homeFolderIcon"));
                    }
                }
            }

            return this;
        }

    }
}