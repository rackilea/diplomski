for (int i = 0; i < size; i++) {
            jLabelAL.add(new JLabel("" + tagNamesAL.get(i))); 
            if (tagNamesAL.get(i).equals("BEHAVIOUR")){
                addCSPComboBox(p1);
                break;
            }