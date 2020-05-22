Dimension DEFAULT_SIZE = ...;
int DEFAULT_RESOLUTION = ...;
Dimension actualScreenSize = Toolkit.getToolkit().getScreenSize();
int actualResolution = Toolkit.getToolkit().getScreenResolution();
AffineTransform at = AffineTransform.getScaleInstance(...,...);
//Apply scaling to your Components and Shapes