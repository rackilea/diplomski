JButton btnGo = new JButton("Start");
btnGo.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
        //Leave this here
        jTextArea.append("line before\n");

        //Create new thread to start method in
        Thread t = new Thread(new Runnable(){
            public void run(){
                myMethodFromOtherClass();

                //Queue the final append in the EDT's event queue
                SwingUtilities.invokeLater(new Runnable(){
                    public void run(){
                        jTextArea.append("line after\n");
                    }
                });
            }
        });

        //Start the thread
        t.start();
    }
}