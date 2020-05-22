class MyWindow extends JFrame { 

    JButton botonCreate = new JButton("Open son windows"); 

    public void doSomething(){ 
        botonCreate.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                JDialog vce = new JDialog(MyWindow.this); 
            } 
        }); 
    } 
}