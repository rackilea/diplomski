import java.applet.Applet;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Square extends Applet{
    int size;
    Color color;
    JButton plus, minus, reset, changeColor, alternate; int shapeDetector;
    public void init(){
        color = Color.GREEN;
        size = 100;
        shapeDetector = 1;
        plus = new JButton("+");
        minus = new JButton("-");
        reset = new JButton("reset");
        changeColor = new JButton("color");
        alternate = new JButton("alternate");
        setLayout(new FlowLayout());
        add(plus); add(minus); add(reset); add(changeColor); add(alternate);
        plus.addActionListener(new ButtonHandler(this));
        minus.addActionListener(new ButtonHandler(this));
        reset.addActionListener(new ButtonHandler(this));
        alternate.addActionListener(new ButtonHandler(this));
        changeColor.addActionListener(new ButtonHandler(this));
    }

    public void paint(Graphics g){
        super.paint(g);
        g.setColor(color);
        if(shapeDetector==1)
            g.fillRect(20, 20, size, size);
        else
            g.drawRect(20, 20, size, size);
    }

    class ButtonHandler implements ActionListener{
        Square myApplet;
        ButtonHandler(Square sq){
            this.myApplet = sq;
        }
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==myApplet.plus)
                myApplet.size+=10;
            if(e.getSource()==myApplet.minus)
                myApplet.size-=10;
            if(e.getSource()==myApplet.reset)
                myApplet.size=100;
            if(e.getSource()==myApplet.changeColor){
                if(myApplet.color==Color.GREEN)
                    myApplet.color=Color.RED;
                else
                    myApplet.color=Color.GREEN;
            }
            if(e.getSource()==myApplet.alternate){
                if(myApplet.shapeDetector==1)
                    myApplet.shapeDetector=2;
                else
                    myApplet.shapeDetector=1;
            }
            myApplet.repaint();
        }
    }
}