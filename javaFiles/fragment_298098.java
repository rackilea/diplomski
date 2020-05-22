textfields = new ArrayList<JTextField>(); // ++

try {
    while (alleVarerList.next()) {
        antalVare = new JTextField();
        textfields.add(antalVare); // ++

        innerPanel.add(new JLabel(alleVarerList.getString(2) + " ("
                + alleVarerList.getString(3) + ",- kr.)"));
        innerPanel.add(antalVare);
        innerPanel.add(new JLabel(""));
        kundeOrdreArrayList.add(antalVare.getText());
    }