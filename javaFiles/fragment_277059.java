class DepositeAL implements ActionListener{

        private Gui gui;
        DepositeAL(Gui gui){
            this.gui = gui;
        }
        public void actionPerformed(ActionEvent arg0) {
            gui.depositScreen();        
        }
    }