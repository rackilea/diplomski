Window window = scene.getWindow();
double screenCenterX = (window.getX() + window.getWidth()/2);
double screenCenterY = (window.getY() + window.getHeight()/2);

Point2D point = pannablePane.screenToLocal(screenCenterX, screenCenterY);

double nodeX = point.getX() - MyNodeImplementation.WIDTH/2;
double nodeY = point.getY() - MyNodeImplementation.HEIGHT/2;