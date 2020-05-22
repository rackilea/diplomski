@Override
public void paint(Graphics g) {

    super.paint(g);
    for (Circles myCircle:circleList
         ) {
        g.setColor(myCircle.getC());
        g.fillOval(myCircle.getX(), myCircle.getY(), myCircle.getR(), myCircle.getR());
    }
}

public static void main(String[] args) {
    Game game = new Game(); 
    numberOfCircle = 5;

    for(int i=0; i<numberOfCircle; i++) {
        myCircle = new Circles();
        circleList.add(myCircle);
    }

}

@Override
public void run() {
    while(true) {
        try {
            Thread.currentThread().sleep(100);
            for (Circles myCircle:circleList
                 ) {
                myCircle.move(myCircle.getS());
            }
            repaint();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

}