public class Test{

    public static void main(String args []){

        class Foo extends JTable {

            @Override
            public void changeSelection(
                final int row, final int column,
                final boolean toggle, final boolean extend) {

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Foo.super.changeSelection(row, column, toggle, extend); 
                        //more code here
                    }
                });
            }
        };

        JTable table = new Foo();

    }//end main

}//end test