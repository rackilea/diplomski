PetrolStations.addActionListener(action);
    Foods.addActionListener(action);
    back.addActionListener(action);
    action2 = new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
            int temp;

            if (e.getSource() == locationChooser) {
                temp = locationChooser.getSelectedIndex();

                switch (temp) {
                    case 0:
                        System.out.println("Address 1");
                        break;
                    case 1:
                        System.out.println("Address 2");
                        break;
                }
            }
        }
    };
    locationChooser.addActionListener(action2);