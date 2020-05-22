Pane pane = new Pane();

double centerX = 300 ;
double centerY = 300 ;
double radius = 30 ;

Circle earth = new Circle(centerX, centerY, radius, Color.web("blue", 0.5));
pane.getChildren().add(earth);

int numMoons = 3 ;
double distance = 100 ;

for (int i = 0 ; i < numMoons; i++) {
    double angle = 2 * i * Math.PI / numMoons ;
    double xOffset = distance * Math.cos(angle);
    double yOffset = distance * Math.sin(angle);
    double x = centerX + xOffset ;
    double y = centerY + yOffset ;
    Circle moon = new Circle(x, y, radius, Color.web("blue", 0.5));
    pane.getChildren().add(moon);
}