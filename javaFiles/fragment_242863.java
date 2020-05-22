switch(Integer.parseInt(jTextField1.getText())){
case 1:
    InchesToCm();
    break;
case 2:
    CmToFeet();
    break;
case 3:
    MetresToYards();
    break;
case 4:
    KmToMetres();
    break;
    default:
        jLabel8.setText("Error, try again");
        break;
}