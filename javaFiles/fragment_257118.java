class DrawingSpace extends JPanel{

    private ToggleButton btn;

    public DrawingSpace(){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(200, 200));
        btn = new ToggleButton("Toggle Button");
        setComponents();
    }

    private void setComponents(){
        add(btn);
        btn.addActionListener(new ActionListener(){             
            @Override
            public void actionPerformed(ActionEvent e){
                btn.toggle();  //change button ON/OFF status every time it is clicked
            }
        });
    }   
}