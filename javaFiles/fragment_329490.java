Pane pane = new Pane();

double centerX = 300 ;
double centerY = 300 ;
double radius = 30 ;

Circle earth = new Circle(centerX, centerY, radius, Color.web("blue", 0.5));
pane.getChildren().add(earth);

int numMoons = 3 ;
double distance = 100 ;

for (int i = 0 ; i < numMoons; i++) {
    double angle = 360.0 * i / numMoons ;

    Circle moon = new Circle(centerX + distance, centerY, radius, Color.web("blue", 0.5));
    Rotate rotate = new Rotate(angle, centerX, centerY);
    moon.getTransforms().add(rotate);
    pane.getChildren().add(moon);
}