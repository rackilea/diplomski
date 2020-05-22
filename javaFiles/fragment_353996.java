button.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(new Runnable(){
               public void run() {
                  panel77.methodInPanel42();
               }});
            }});