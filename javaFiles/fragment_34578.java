public class Inbox {
    //...
    Inbox() {
        //...
        ricList.addListSelectionListener(new ListSelectionListener {
            public void valueChanged(ListSelectionEvent s) {
                String str = (String) ricList.getSelectedValue();
                if(str.equals("Alex"))
                    System.out.println("Alex");
                else if(str.equals("John"))
                    System.out.println("John");
                else
                    System.out.println("Other name");            
            } 
        });
        //...
        invList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent s) {
                String str = (String) invList.getSelectedValue();
                if(str.equals("Alex"))
                    System.out.println("Alex");
                else if(str.equals("John"))
                    System.out.println("John");
                else
                    System.out.println("Other name");            
            } 
        });
    }
}