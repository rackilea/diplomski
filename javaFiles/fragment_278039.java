public class Ball extends Component {

public static double ballX = rand.nextInt(500) + 40;
public static double ballY = rand.nextInt(300) + 10;
public static Ball[] balls = new Ball[20];

public Ball() {

}

public void draw(Graphics g2) {            
    Color color = new Color(r, g, b);
    g2.setColor(color);
    g2.fillOval((int) ballX, (int) ballY, 30, 30);
}
}