Component columnHeader = scrollPane.getColumnHeader().getView();
Component rowHeader = scrollPane.getRowHeader().getView();
Component view = scrollPane.getViewport().getView();

int width = rowHeader.getPreferredSize().width + view.getPreferredSize().width;
int height = columnHeader.getPreferredSize().height + view.getPreferredSize().height;

BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
Graphics2D g2d = img.createGraphics();
g2d.setColor(Color.WHITE);
g2d.fillRect(0, 0, width, height);
int xOffset = rowHeader.getPreferredSize().width;
int yOffset = columnHeader.getPreferredSize().height;

Graphics2D rowHeaderG = (Graphics2D) g2d.create();
rowHeaderG.translate(0, yOffset);
rowHeader.printAll(rowHeaderG);
rowHeaderG.dispose();

Graphics2D colHeaderG = (Graphics2D) g2d.create();
colHeaderG.translate(xOffset, 0);
columnHeader.printAll(colHeaderG);
colHeaderG.dispose();

Graphics2D viewG = (Graphics2D) g2d.create();
viewG.translate(xOffset, yOffset);
view.printAll(viewG);
viewG.dispose();
g2d.dispose();