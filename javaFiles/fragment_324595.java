for (String fieldName : fieldsList) {
        {
            {
                JLabel lbl = new JLabel(fieldName + ":");
                lbl.setBounds(33, counter, 130, 14);
                getContentPane().add(lbl);
            }
            counter += 25;
        }
    }