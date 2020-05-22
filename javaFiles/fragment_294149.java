import java.awt.*;
import java.applet.Applet;

public class BarryViper extends java.applet.Applet {
    Rectangle top, mid, bot;
    int numColor;
    int pageNum;

    public void init() {
        top = new Rectangle(100, 75, 150, 150);
        mid = new Rectangle(100, 275, 150, 150);
        bot = new Rectangle(100, 475, 150, 150);
        numColor = 0;
        pageNum = 0;
    }

    public void paint(Graphics g) {

        switch (pageNum) {
        case 0:
            page1(g);
            break;
        case 1:
            page2(g);
            break;
        case 2:
            page3(g);
            break;
        case 3:
            page4(g);
            break;
        }
    }

    public boolean mouseDown(Event e, int x, int y) {
        if (top.inside(x, y))
            numColor = 1;
        else if (mid.inside(x, y))
            numColor = 2;
        else if (bot.inside(x, y))
            numColor = 3;
        else
            numColor = 0;

        switch (numColor) {
        case 0:
            pageNum = 0;
            break;
        case 1:
            pageNum = 0;
            break;
        case 2:
            pageNum = 0;
            break;
        case 3:
            pageNum = pageNum;
            break;
        }

        repaint();
        return true;

    }

    public void page1(Graphics g) {

        Expo.setBackground(g, 0);
        Expo.setColor(g, Expo.white);
        Expo.fillRectangle(g, 100, 75, 250, 225);
        Expo.fillRectangle(g, 100, 275, 250, 425);
        Expo.fillRectangle(g, 100, 475, 250, 625);
        Expo.setFont(g, "Arial", Font.BOLD, 20);
        Expo.drawString(
                g,
                "-You Have been Tasked with slaying the dragon that has forsaken these lands.",
                260, 75);
        Expo.drawString(
                g,
                "-This quest will be long, difficult, and full of Monty Python refrences.",
                260, 95);
        Expo.drawString(g, "-Do you accept this task?", 260, 115);
        Expo.setColor(g, Expo.red);
        Expo.setFont(g, "Arial", Font.BOLD, 15);
        Expo.drawString(g, "Nah", 155, 155);
        Expo.drawString(g, "I Prefer", 145, 350);
        Expo.drawString(g, "Monty Java", 130, 370);
        Expo.drawString(g, "Sure I could", 130, 540);
        Expo.drawString(g, "waste some time", 115, 560);
    }

    public void page2(Graphics g) {

        Expo.setBackground(g, 0);
        Expo.setColor(g, Expo.white);
        Expo.fillRectangle(g, 100, 75, 250, 225);
        Expo.fillRectangle(g, 100, 275, 250, 425);
        Expo.fillRectangle(g, 100, 475, 250, 625);
        Expo.setFont(g, "Arial", Font.BOLD, 20);
        Expo.drawString(
                g,
                "-Good Choice! You now decide to roam down an old dirt road, when suddenly",
                260, 75);
        Expo.drawString(g,
                "-You encounter a group of three Goblins blocking your path",
                260, 95);
        Expo.drawString(g, "-What is your reaction?", 260, 115);
        Expo.setColor(g, Expo.red);
        Expo.setFont(g, "Arial", Font.BOLD, 15);
        Expo.drawString(g, "Hide from them ", 115, 155);
        Expo.drawString(g, "Try talking", 130, 350);
        Expo.drawString(g, "To them", 130, 370);
        Expo.drawString(g, "Attack them", 130, 540);
        Expo.drawString(g, "immediately", 130, 560);
    }

    public void page3(Graphics g) {

        Expo.setBackground(g, 0);
        Expo.setColor(g, Expo.white);
        Expo.fillRectangle(g, 100, 75, 250, 225);
        Expo.fillRectangle(g, 100, 275, 250, 425);
        Expo.fillRectangle(g, 100, 475, 250, 625);
        Expo.setFont(g, "Arial", Font.BOLD, 75);
        Expo.drawString(g, "PAGE 3", 200, 75);
    }

    public void page4(Graphics g) {

        Expo.setBackground(g, 0);
        Expo.setColor(g, Expo.white);
        Expo.fillRectangle(g, 100, 75, 250, 225);
        Expo.fillRectangle(g, 100, 275, 250, 425);
        Expo.fillRectangle(g, 100, 475, 250, 625);
        Expo.setFont(g, "Arial", Font.BOLD, 75);
        Expo.drawString(g, "PAGE 4", 200, 75);
    }

}