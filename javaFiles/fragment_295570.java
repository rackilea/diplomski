String[] comboData = new String[allResult.size()];
for (int i = 0; i < allResult.size(); i++){

    ...

    String investorName = (String) ((Hashtable) obj).get("investorName");

    comboData[i] = investorName

    ...

}

ComboBox investorNames = new ComboBox(comboData);
details.addComponent(investorNames);

....