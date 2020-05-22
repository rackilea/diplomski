class gui{
        public static void main(String args[]){
            layoutBorder lb=new layoutBorder("check");
        }
    }

class layoutBorder extends JFrame{
    layoutBorder(String title){
        super(title);
        setLayout(null);
        setSize(200, 200);
        JButton jb=new JButton("JB");
        jb.setLocation(10, 10);
        jb.setSize(40, 30);
        add(jb);
        setVisible(true);
    }
}