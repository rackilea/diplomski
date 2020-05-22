button.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            theApp.size = 200;
            frame.getContentPane().repaint();
            //OR frame.repaint();
        }
    });