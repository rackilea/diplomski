Component source = (Component)evt.getSource();
Point location = source.getLocation();
Dimension size = source.getSize();

int xPos = location.x + ((size.width - PMenu.getWidth()) / 2;
int yPos = location.y + size.height;
Pmenu.show(source, xPos, yPos);