public class Inbox {
    //...
    Inbox() {
        //...
        ricList.addListSelectionListener(new RicListSelectionListener());
        //...
        invList.addListSelectionListener(new InvListSelectionListener());
    }
    //...
    public class RicListSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent s) {
            String str = (String) ricList.getSelectedValue();
            if(str.equals("Alex"))
                System.out.println("Alex");
            else if(str.equals("John"))
                System.out.println("John");
            else
                System.out.println("Other name");            
        } 
    }

    public class InvListSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent s) {
            String str = (String) invList.getSelectedValue();
            if(str.equals("Alex"))
                System.out.println("Alex");
            else if(str.equals("John"))
                System.out.println("John");
            else
                System.out.println("Other name");            
        } 
    }
}