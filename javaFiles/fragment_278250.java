public void actionPerformed(ActionEvent e) {
            // get the button that was pressed
            JButton b = (JButton) e.getSource();

            // fire appropriate event
            if (b.getName().equals("Normal Setup")) {
                // set up for normal simulation
                fireSimulationEvent(SimulationEvent.NORMAL_SETUP_EVENT);
            } 
......