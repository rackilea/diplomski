Object[] header = new Object[]{"Id", "Rijksregisternummer", "Naam", "Voornaam"
                              ,"Straat", "Nummer", "Bus", "Postnummer"
                              ,"Gemeente", "Telefoonnummer"};

DefaultTableModel model = new DefaultTableModel(header, 0);

for (int index = 0; index < arrpBag.length; index++) {
    Object[] row = new Object[]{ arrpBag[index].getId()
                               , arrpBag[index].getRijksregisternummer()
                               , arrpBag[index].getNaam()
                               , arrpBag[index].getVoornaam()
                               , arrpBag[index].getStraat()
                               , arrpBag[index].getNummer()
                               , arrpBag[index].getBus()
                               , arrpBag[index].getPostnummer()
                               , arrpBag[index].getGemeente()
                               , arrpBag[index].getTelefoonnummer() };

    model.addRow(row);
}

taTabelPersonen.setModel(model);