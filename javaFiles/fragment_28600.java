package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Bullet {
    private int x, y;
    private int speed, ttl;
    public final Timer timer1;

    public Bullet(int x, int y, int speed){

        this.x = x;
        this.y = y;
        this.speed= speed;
        this.ttl = 250;

        ActionListener actListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Move();
            }
        };
        this.timer1 = new Timer(50, actListener);
        timer1.start();
    }

    public int getdy(){
        return y;
    }
    public void setdy(int newy){
        y = newy;
    }
    public int getdx(){
        return x;
    }
    public int Move(){
    //Do some calculation to perform loss of velocity within a reasonable range. Because these number might be overkill
    this.speed -= (ttl / 100);
    y += this.speed;
    ttl--;
    return y;
    }
}