int value = 0;
ArrayList<Line> l = new ArrayList<Line>();

void setup() {
    size(500,500);

   for (int i = 0; i < 20; ++i) {
       l.add(new Line());  
   }
}

void draw() {

    background(57, 76, 222);

    strokeWeight(3);
    for (int i = 0; i < l.size(); ++i) {
       l.get(i).display();
    }
}

void mousePressed() {

    for (int i = 0; i < l.size(); ++i) {

        if (l.get(i).isHit(mouseX, mouseY)) {
            l.get(i).setColor(color(255, 0, 0) );
        }
    } 
}

class Line {
    int ranX1, ranX2, ranY1, ranY2;
    color col;

    Line() {
        col = color(255);
        ranX1 = int(random(50,450));
        ranX2 = int(random(50,450));
        ranY1 = int(random(50,450));
        ranY2 = int(random(50,450));
    }

    void setColor(color c) {
        col = c;
    }

    boolean isHit(int x, int y) {

        final int hit_dist = 5;

        PVector D = new PVector(ranX2 - ranX1, ranY2 - ranY1);
        if ( D.mag() > 0.0 )
            D.normalize();

        PVector vP1 = new PVector(x - ranX1, y - ranY1);
        if ( D.dot( vP1 ) < 0.0 )
            return false;

        PVector vP2 = new PVector(x - ranX2, y - ranY2);
        if ( D.dot( vP2 ) > 0.0 )
            return false;

        PVector X = new PVector(ranX1, ranY1);
        X.add( D.mult( D.dot( vP1 ) ) );
        boolean hit = X.dist(new PVector(x, y)) < hit_dist; 

        return hit;
    }

    void display() {
        stroke(col);
        line(ranX1, ranY1, ranX2, ranY2);
    }
}