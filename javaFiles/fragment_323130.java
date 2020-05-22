toggle.getModel().addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent evt) {
           ButtonModel model = (ButtonModel) evt.getSource();

           // this doesn't work
           if (model.isRollover()) {
              System.out.println(model.getActionCommand() + " is rolled over");
           }

           // but this does
           if (model.isSelected()) {
              System.out.println(model.getActionCommand() + " is selected");
           }
        }
     });