setBackground(Color.black);
    clearCounter = 0;

    Timer t = new Timer(1000, this);
    t.start();
    check = 0;   <------------ New Variable


}
public void paint(Graphics g)
{
    if (check==0){
        g.clearRect(0, 0, 500, 400);   <------------ To Ensure That it will Excute Only Once , beacuse check is incremented later in Code
    }



    clearCounter++;
    check++;
    Graphics2D g2 = (Graphics2D) g;

    if (clearCounter == 5){
        g2.clearRect(0, 0, 500, 400);
        clearCounter=0;
    }

    for (int i = 1; i <= 40; i++) {
        Color c = chooseColor();
        g2.setColor(c);
        Font f = chooseFont();
        g2.setFont(f);
        drawJava(g2);
        }
}