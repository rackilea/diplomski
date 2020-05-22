import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class RadicalRacing extends JFrame {
private static final long serialVersionUID = 1L;

// Environment size
final int WIDTH = 900, HEIGHT = 650;
// Player speed
double p1Speed = .5, p2Speed = .5;
// Integer values that represent directions
final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;
// These keep track of the players directions(default = up)
int p1Direction = UP;
int p2Direction = UP;

// Environment objects
Rectangle left = new Rectangle(0, 0, WIDTH / 9, HEIGHT);
Rectangle right = new Rectangle((WIDTH / 9) * 8, 0, WIDTH / 9, HEIGHT);
Rectangle top = new Rectangle(0, 0, WIDTH, HEIGHT / 9);
Rectangle bottom = new Rectangle(0, (HEIGHT / 9) * 8, WIDTH, HEIGHT / 9);
Rectangle center = new Rectangle((int) ((WIDTH / 9) * 2.5),
(int) ((HEIGHT / 9) * 2.5), (int) ((WIDTH / 9) * 5),
(HEIGHT / 9) * 4);
Rectangle obstacle = new Rectangle(WIDTH / 2, (int) ((HEIGHT / 9) * 7),
WIDTH / 10, HEIGHT / 9);
Rectangle obstacle2 = new Rectangle(WIDTH / 3, (int) ((HEIGHT / 9) * 5),
WIDTH / 10, HEIGHT / 4);
Rectangle obstacle3 = new Rectangle(2 * (WIDTH / 3),
(int) ((HEIGHT / 9) * 5), WIDTH / 10, HEIGHT / 4);
Rectangle obstacle4 = new Rectangle(WIDTH / 3, HEIGHT / 9, WIDTH / 30,
HEIGHT / 9);
Rectangle obstacle5 = new Rectangle(WIDTH / 2, (int) ((HEIGHT / 9) * 1.5),
WIDTH / 30, HEIGHT / 4);
Rectangle finish = new Rectangle(WIDTH / 9, (HEIGHT / 2) - HEIGHT / 9,
(int) ((WIDTH / 9) * 1.5), HEIGHT / 70);
Rectangle p1 = new Rectangle(WIDTH / 9, HEIGHT / 2, WIDTH / 30, WIDTH / 30);
Rectangle p2 = new Rectangle(
((WIDTH / 9) + ((int) ((WIDTH / 9) * 1.5) / 2)), (HEIGHT / 2)
+ (HEIGHT / 10), WIDTH / 30, WIDTH / 30);

// Start the program by calling the non-static constructor.
public static void main(String[] args) { new RadicalRacing(); }

// Constructor. 
public RadicalRacing() {
super("Radical Racing"); // title of the window
setSize(WIDTH, HEIGHT);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);

// A thread is nessicary to run the environment graphics and controls
// at the same time. The graphics will run on the main thread and
// the controls will be operated on a second thread.
Movement m = new Movement();
m.start();

try { 
while(true) {
// Delay the refresh rate of the graphics.
Thread.sleep(50);
// Update the environment graphics with new positioning, etc
repaint(); 
}
} catch(Exception e) { }
}

@Override
public void paint(Graphics g) {
// The racetrack itself is the background of the interface.
g.setColor(Color.DARK_GRAY);
g.fillRect(0, 0, WIDTH, HEIGHT);

// Draw the environment outside of the race track
g.setColor(Color.BLACK);
g.fillRect(left.x, left.y, left.width, left.height);
g.fillRect(right.x, right.y, right.width, right.height);
g.fillRect(top.x, top.y, top.width, top.height);
g.fillRect(bottom.x, bottom.y, bottom.width, bottom.height);
g.fillRect(center.x, center.y, center.width, center.height);
g.fillRect(obstacle.x, obstacle.y, obstacle.width, obstacle.height);
g.fillRect(obstacle2.x, obstacle2.y, obstacle2.width, obstacle2.height);
g.fillRect(obstacle3.x, obstacle3.y, obstacle3.width, obstacle3.height);
g.fillRect(obstacle4.x, obstacle4.y, obstacle4.width, obstacle4.height);
g.fillRect(obstacle5.x, obstacle5.y, obstacle5.width, obstacle5.height);

// Draw the starting lines.
g.setColor(Color.WHITE);
// ..outer player starting line..
Rectangle lineO = new Rectangle(WIDTH / 9, HEIGHT / 2, (int) ((WIDTH / 9) * 1.5) / 2, HEIGHT / 140);
// ..inner player starting line..
Rectangle lineI = new Rectangle(
((WIDTH / 9) + ((int) ((WIDTH / 9) * 1.5) / 2)), (HEIGHT / 2)
+ (HEIGHT / 10), (int) ((WIDTH / 9) * 1.5) / 2,
HEIGHT / 140);
g.fillRect(lineO.x, lineO.y, lineO.width, lineO.height);
g.fillRect(lineI.x, lineI.y, lineI.width, lineI.height);

// Draw the finish line.
g.setColor(Color.YELLOW);
g.fillRect(finish.x, finish.y, finish.width, finish.height);

// Draw player #1
g.setColor(Color.BLUE);
g.fillRect(p1.x, p1.y, p1.width, p1.height);

// Draw player #2
g.setColor(Color.red);
g.fillRect(p2.x, p2.y, p2.width, p2.height);
}

private class Movement extends Thread implements KeyListener {

public void run() {

// Activate keyboard controls
addKeyListener(this);

try {

while(true) {
    // Delay the rate at which these variables are calculated.
    // Higher the number, the slower the race will feel.
    // Lower the number, the faster.
    // Too low and the game will be glitchy.
    Thread.sleep(75);

    // Check to see if the car hits the outside of the walls.
    // If so, slow it's speed temporarily.
    if(    p1.intersects(left)
    ||  p1.intersects(right)
    ||  p1.intersects(top)
    ||  p1.intersects(bottom)
    ||  p1.intersects(obstacle)
    ||    p1.intersects(obstacle2)
    ||  p1.intersects(p2)
    ||  p1.intersects(obstacle3)
    ||  p1.intersects(obstacle4)
    ||  p1.intersects(obstacle5))
    { p1Speed = -4; }

    if(    p2.intersects(left)
    ||  p2.intersects(right)
    ||  p2.intersects(top)
    ||  p2.intersects(bottom)
    ||  p2.intersects(obstacle)
    ||    p2.intersects(obstacle2)
    ||  p2.intersects(p1)
    ||  p2.intersects(obstacle3)
    ||  p2.intersects(obstacle4)
    ||  p2.intersects(obstacle5))
    { p2Speed = -4; }

    // If the car hits the center, slow it's speed just a little bit.
    if(p1.intersects(center)) p1Speed = -2.5;
    if(p2.intersects(center)) p2Speed = -2.5;

    // Now increase speed some.
    if(p1Speed <= 5) p1Speed += .2;
    if(p2Speed <= 5) p2Speed += .2;

    // Now move the player in the direction they're facing.
    if(p1Direction == UP)  p1.y -= (int)p1Speed;
    if(p1Direction == DOWN)  p1.y += (int)p1Speed;
    if(p1Direction == LEFT)  p1.x -= (int)p1Speed;
    if(p1Direction == RIGHT)  p1.x += (int)p1Speed;

    if(p2Direction == UP)  p2.y -= (int)p2Speed;
    if(p2Direction == DOWN)  p2.y += (int)p2Speed;
    if(p2Direction == LEFT)  p2.x -= (int)p2Speed;
    if(p2Direction == RIGHT)  p2.x += (int)p2Speed;
}

} catch (Exception e) { e.printStackTrace(); }
}

// Unused methods required for implementation.
public void keyPressed(KeyEvent event)  { }
public void keyReleased(KeyEvent event) { }

public void keyTyped(KeyEvent event) {
char c = event.getKeyChar();
if(c == 'a') p1Direction = LEFT;
if(c == 's') p1Direction = DOWN;
if(c == 'd') p1Direction = RIGHT;
if(c == 'w') p1Direction = UP;

if(c == 'j') p2Direction = LEFT;
        if(c == 'k') p2Direction = DOWN;
        if(c == 'l') p2Direction = RIGHT;
        if(c == 'i') p2Direction = UP;
 }
 }

 }