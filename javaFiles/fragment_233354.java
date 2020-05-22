for (int i =10; i<634; i+=(a+10))//buildings
{

  g2d.setColor(Color.GRAY);
  g2d.drawRect(i, maxY-height, width, height);
  g2d.fillRect(i, maxY-height, width, height);


  rows = Math.round((height)/25);
  columns = Math.round(width/25);

  for (int j = 1; j<=columns; j++)//windows
  {
    for (int k = 1; k<=rows; k++)
    {
      g2d.setColor(Color.BLACK);
      g2d.drawRect(i+5*j+20*(j-1), (maxY-height)+5*k+20*(k-1), 20, 20);
      if (Math.random()<0.7)
      {
        g2d.setColor(Color.YELLOW);
        g2d.fillRect(i+5*j+20*(j-1), (maxY-height)+5*k+20*(k-1), 20, 20);
      }
      else
      {
        g2d.setColor(transYellow);
        g2d.fillRect(i+5*j+20*(j-1), (maxY-height)+5*k+20*(k-1), 20, 20);
        g2d.setColor(transYellow);
        g2d.fillRect(i+5*j+20*(j-1), (maxY-height)+5*k+20*(k-1), 20, 20);
      }
    }
  }

  addBuilding();
  a = width;
  height = (int)(Math.random()*462+100);
  width = (int)(Math.random()*100+100);

}