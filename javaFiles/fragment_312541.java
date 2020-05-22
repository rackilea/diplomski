public class MyClass extends MyBaseClass {
    private MouseAdapter ma;

    public MyClass () {
        final MyClass that = this;
        ma = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                that.myMouseClickedHandler(e);
            }
        };
    }

    public void myMouseClickedHandler(MouseEvent e) {
        if (e.getClickCount() == 2) {
            // Double click
        } else {
           // Simple click
        }        
    }
 }