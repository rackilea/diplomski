class DrawingSpace extends JPanel{

    private JLabel label;
    private JButton button;
    private Timer timer;    

    public DrawingSpace(){
        setPreferredSize(new Dimension(200, 300));
        initComponents();
        add(label);
        add(button);    
    }

    public void initComponents(){
        label = new JLabel("I am a JLabel !");
        label.setBackground(Color.YELLOW);
        label.setOpaque(true);
        button = new JButton("Move");

        //Move every (approx) 5 milliseconds        
        timer = new Timer(5, new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e){
                //Move 1 px everytime
                label.setLocation(label.getLocation().x, label.getLocation().y+1);  
            }               
        });     
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(!timer.isRunning())
                    timer.start();
                else
                    timer.stop();   
            }   
        }); 
    }
}