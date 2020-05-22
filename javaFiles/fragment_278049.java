JFormattedTextField formattedTextField = new JFormattedTextField();     
try {
    MaskFormatter maskFormatter = new MaskFormatter("##:##:##;##");
    maskFormatter.setPlaceholderCharacter('0');
    maskFormatter.install(formattedTextField);
} catch (ParseException e) {
    e.printStackTrace();
}