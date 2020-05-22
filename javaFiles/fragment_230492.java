import processing.core.PApplet;
import processing.core.PGraphics;

public class Prototype extends PApplet {

public static void main(String[] args) {
    PApplet.main(Prototype.class);
}

int xOffset = 0, yOffset = 0;
int xOffsetP, yOffsetP;
int mouseDownX, mouseDownY;
boolean move = false;
PGraphics graph;

@Override
public void settings() {
    size(500, 500);
}

@Override
public void setup() {

    graph = createGraphics(2000, 2000); // Create graph 2000x2000px
    graph.beginDraw();

    graph.background(255);
    graph.fill(0);
    for (int i = 0; i < 1000; i++) { // Adds 1000 random points to graph
        graph.ellipse(random(2000), random(2000), 3, 3);
    }

    for (int i = 0; i < graph.height; i += 50) { // Adds Y-axis labels
        graph.text(i, 5, graph.height - i);
    }

    graph.line(0, 0, 1999, 0); // Graph edge/border
    graph.line(0, 1999, 1999, 1999);
    graph.line(0, 0, 0, 1999);
    graph.line(1999, 0, 1999, 2000);

    graph.endDraw();
}

@Override
public void draw() {
    background(255);

    if (move) {
        xOffset = mouseDownX - mouseX + xOffsetP;
        yOffset = mouseY - mouseDownY + yOffsetP;

        xOffset = constrain(xOffset, 0, graph.width - width); // Optional
        yOffset = constrain(yOffset, 0, graph.height - height); // Optional
    }

    image(graph, -xOffset, yOffset - graph.height + height);

    fill(255, 0, 0);
    text("X Offset: " + xOffset, 0, 10);
    text("Y Offset: " + yOffset, 0, 25);
}

@Override
public void mousePressed() {
    move = true;
    mouseDownX = mouseX;
    mouseDownY = mouseY;
}

@Override
public void mouseReleased() {
    move = false;
    xOffsetP = xOffset;
    yOffsetP = yOffset;
}

}