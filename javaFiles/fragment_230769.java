JButton button = new JButton("Press Me");
button.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e) {

        Timer timer = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Print after one second");
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
});