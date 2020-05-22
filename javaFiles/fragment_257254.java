public static Border getRadioButtonBorder() {
UIDefaults table = UIManager.getLookAndFeelDefaults();
Border radioButtonBorder = new BorderUIResource.CompoundBorderUIResource(
           new BasicBorders.RadioButtonBorder(
                   table.getColor("RadioButton.shadow"),
                                       table.getColor("RadioButton.darkShadow"),
                                       table.getColor("RadioButton.light"),
                                       table.getColor("RadioButton.highlight")),
                     new MarginBorder());
return radioButtonBorder;
}