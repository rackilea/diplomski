public void stateChanged(ChangeEvent e) {
    Component[] components = characterCreationPanel.getComponents();
    Component component = null; 
    strengthValue = strengthModel.getNumber().intValue();
    constitutionValue = constitutionModel.getNumber().intValue();
    dexterityValue = dexterityModel.getNumber().intValue();
    intelligenceValue = intelligenceModel.getNumber().intValue();
    for (int i = 0; i < components.length; i++)
    {
        component = components[i];
        if (component instanceof JLabel){
            if (((JLabel) component).getText().substring(0, 5).equals("Stat ")){
                ((JLabel) component).setText("Stat Points Left: " + Integer.toString(50 - (strengthValue + constitutionValue + dexterityValue + intelligenceValue)));
                if ((strengthValue + constitutionValue + dexterityValue + intelligenceValue) == 50){
                    System.out.println("Hit your cap.");
                }
            }       
        }
        strengthModel.setMaximum(50 - (constitutionValue + dexterityValue + intelligenceValue));
        constitutionModel.setMaximum(50 - (strengthValue + dexterityValue + intelligenceValue));
        dexterityModel.setMaximum(50 - (strengthValue + constitutionValue + intelligenceValue));
        intelligenceModel.setMaximum(50 - (strengthValue + constitutionValue + dexterityValue));
    }
}