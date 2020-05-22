...
Container powZawartosci = getContentPane();
public Ramka()
    {
    setSize(SZEROKOSC, WYSOKOSC);
    setTitle("Siatka bryły by Paweł Mysior");
    setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));//Only this line is inserted.
    }
public void addRectangle(int startX, int startY, int sizeX)
    {
    drawRectangle rect = new drawRectangle(startX, startY, sizeX);
    powZawartosci.add(rect);
    }  
...