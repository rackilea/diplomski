String sizeValue = configProps.getProperty("tFont.size", "12");
int size = Integer.parseInt(sizeValue);

String fontName = configProps.getProperty("tFont.name", UIManager.getFont("Label.font").getName());

String colorValue = configProps.getProperty("tFont.color", Integer.toString(Color.BLACK.getRGB()));
Color color = new Color(Integer.parseInt(colorValue), true);