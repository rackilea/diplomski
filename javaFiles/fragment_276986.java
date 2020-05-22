Runnable doWorkRunnable = new Runnable() {
        public void run() {
            for(TestComponent c : Config.getComponents()){
                frame.getContentPane().add(new ComponentPanel(c));
                frame.getContentPane().add(Box.createRigidArea(new Dimension(5,0)));
            }
        }
    };
SwingUtilities.invokeLater(doWorkRunnable);