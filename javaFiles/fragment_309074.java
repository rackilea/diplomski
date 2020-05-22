public class Cara extends JPanel implements ActionListener {
    private static ArrayList<RandomShape> randomShape;

    public Cara() {
        randomShape = new ArrayList<RandomShape>();
    }
}

private void regenerate() {
    //clear the shapes list 
    randomShape.clear();

    // create random shapes
    RandomShape shape = null;
    int randomInt;
    for(int i = 0; i < 10 + random.nextInt(MAX_AMOUNT_OF_SHAPES); i++) {
        randomInt = random.nextInt(AMOUNT_OF_DISTINCT_SHAPES);

        switch (randomInt) {
            case 0: 
                shape = new Oval(400,300);
                break;
            case 1: 
                shape = new Circle(400,300);
                break;
            case 2: 
                shape = new Rectangle(400,300);
                break;
            case 3: 
                shape = new Square(400,300);
                break;
            case 4: 
                shape = new RoundRectangle(400,300);
                break;
        } 
        randomShape.add(shape);
    }

    //random position
    RandomShape position = null;
    int randomIntpos;
    for (int i = 0; i < (MAX_SIZE_X_COORDINATE*MAX_SIZE_Y_COORDINATE) ; i++){
        randomIntpos = random.nextInt();
    }
}

public class RoundRectangle extends RandomShape {
    private int x;
    private int y;
    //constructor for random position
    public RoundRectangle(int x, int y) {
        this.x = x
        this.y = y
    }

    @Override
    public void draw(Graphics g){
        g.drawRoundRect(x,y,width,height,arcWidth,arcHeight);
        g.fillRoundRect(x,y,width,height,arcWidth,arcHeight);
        g.setColor(randomColor);
    }
}