GridPerspective grid;

void setup() {
    size(600, 600, P2D);
    grid = new GridPerspective(10, 10);
}


void draw() {
    background(0);
    grid.draw();
}

void mouseClicked() {
    grid.addCorner(new PVector(mouseX, mouseY));
}

public class GridPerspective {

    int cols, rows;
    PVector[] corners = new PVector[4];
    int selC;
    PVector[][] points;

    public GridPerspective(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public void addCorner(PVector corner) {
        if(selC < 4) {
            corners[selC++] = corner;
            if(selC == 4) update();
        }
    }

    public void update() {
        if(corners[0] == null || corners[1] == null || corners[2] == null || corners[3] == null) return;
        PVector[] vanishing = new PVector[] {
            linesIntersection(corners[0], corners[3], corners[1], corners[2]),
            linesIntersection(corners[0], corners[1], corners[3], corners[2])
        };
        PVector topHorizon = PVector.sub(vanishing[1], vanishing[0]);
        PVector bottomHorizon = PVector.add(corners[3], topHorizon);
        PVector[] bottomLimits = new PVector[] {
            linesIntersection(corners[3], bottomHorizon, vanishing[0], corners[1]),
            linesIntersection(corners[3], bottomHorizon, vanishing[1], corners[1])
    };
        points = new PVector[rows][cols];
        for(int r = 0; r < rows; r++) {
            PVector bpr = PVector.lerp(corners[3], bottomLimits[0], (float)r / (rows-1));
            for(int c = 0; c < cols; c++) {
                PVector bpc = PVector.lerp(corners[3], bottomLimits[1], (float)c / (cols-1));
            points[r][c] = linesIntersection(bpr, vanishing[0], bpc, vanishing[1]);
            }
        }
    }

    public void draw() {
        if(points != null) {    
            fill(255);
            for(int r = 0; r < rows; r++) {
                for(int c = 0; c < cols; c++) {
                    ellipse(points[r][c].x, points[r][c].y, 4, 4);
                }
            }   
        }
    }

    private PVector linesIntersection(PVector p1, PVector p2, PVector p3, PVector p4) {
        float d = (p2.x-p1.x) * (p4.y - p3.y) - (p2.y-p1.y) * (p4.x - p3.x);
        if(d == 0) return null;
        return new PVector(p1.x+(((p3.x - p1.x) * (p4.y - p3.y) - (p3.y - p1.y) * (p4.x - p3.x)) / d)*(p2.x-p1.x), p1.y+(((p3.x - p1.x) * (p4.y - p3.y) - (p3.y - p1.y) * (p4.x - p3.x)) / d)*(p2.y-p1.y));
    }

}