fromListDistance.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            //saving the selected choice   
            String choise=fromListDistance.getSelectedItem().toString();

            //here we remove all items from the combo box
            toListDistance.removeAllItems();

            for (int i = 0; i < convertToDistance.length; i++) {
                String distance=convertToDistance[i];
                //compare the selected choice with the convertToDistance[i]
                if (choise.equals(distance)) {
                    continue;
                }
                toListDistance.addItem(distance);
            }
        }
    });