g.setColor(Color.BLUE);
int position = rectPos;
while (position<150) {
   position += 10;
   g.drawRect(position, position, 100, 10);
   g.fillRect(position, position, 100, 10);
}