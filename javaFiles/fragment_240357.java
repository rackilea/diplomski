public class BallWorld {
....
private Random random = new Random();
private Color[] colors={Color.red,Color.blue,Color.yellow};

public BallWorld(int ballCnt){
    super();
    setSize(FRAMEWIDTH, FRAMEHEIGHT);
    setTitle("My Bouncing Ball Application");

    ballArr = new Ball[ballCnt];
    this.ballCnt = ballCnt;

    for (int i=0; i < ballCnt; i++){
---->   // Create attributes here
        int bcn = random.nextInt(colors.length);
        Color ballcolor = colors[bcn];
        int ballradius = random.nextInt(10); // change to suit your needs
---->   int posx = random.nextInt(200); // change to suit your needs
---->   int posy = random.nextInt(200); // change to suit your needs
        // this creates a ball given the above calculated parameters
---->   ballArr[i] = new Ball(new Point(posx,posy), ballradius, ballcolor);
        int ddx = (int) (5*Math.random()); //Exercise 1
        int ddy = (int) (4*Math.random());  //Exercise 1
        ballArr[i].setMotion(ddx, ddy); 
    }
}