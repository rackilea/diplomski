addMouseListener(new MouseAdapter() {
    @Override
    public void mousePressed(MouseEvent e) {        
        if(value%2 == 0) {
            clicked++;
            if(clicked == 2) {
                System.out.println("even");
                timer.start();      
            }
        } else if(value%2 == 1) {
            System.out.println("odd");
            timer.start();          
        }
    }
});