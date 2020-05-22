@Override
public void start(Stage primaryStage) throws Exception {
    double w = 600;
    double h = 600;

    Rotate rotation = new Rotate(0, 0, 0);
    Line ship = new Line(0, 0, 20, 0);
    ship.getTransforms().add(rotation);

    ship.setLayoutX(w / 2);
    ship.setLayoutY(h / 2);

    Pane root = new Pane(ship);
    root.setPrefSize(w, h);

    class Animator extends AnimationTimer {
        // the current speed
        double vx;
        double vy;

        // the direction the ship is facing
        double directionX = 1;
        double directionY = 0;

        // the current acceleration magnitude
        double acceleration = 0;

        @Override
        public void handle(long now) {
            if (acceleration > 0) {
                // speed up in the direction the ship is currently facing
                vx += directionX * acceleration * 0.001;
                vy += directionY * acceleration * 0.001;

                acceleration -= 0.1;
            } else if (vx != 0 || vy != 0) {
                // decelerate
                double speed = Math.hypot(vx, vy);

                // constant deceleration opposite to velocity
                double correctionFactor = Math.max((speed - 0.01) / speed, 0);
                vx *= correctionFactor;
                vy *= correctionFactor;
            }

            // update position
            ship.setLayoutX(ship.getLayoutX() + vx);
            ship.setLayoutY(ship.getLayoutY() + vy);
        }

    }

    Animator animator = new Animator();
    animator.start();

    Scene scene = new Scene(root);

    // make sure the ship always faces the mouse
    root.setOnMouseMoved(evt -> {
        double dx = evt.getX() - ship.getLayoutX();
        double dy = evt.getY() - ship.getLayoutY();

        if (dx == 0 && dy == 0) {
            // handle special case of mouse being in the same position as the ship
            dx = 1;
        }

        // assign normalized direction
        double magnitude = Math.hypot(dx, dy);
        animator.directionX = dx / magnitude;
        animator.directionY = dy / magnitude;

        // update ship rotation
        rotation.setAngle(Math.toDegrees(Math.atan2(dy, dx)));
    });

    root.setOnMouseClicked(evt -> {
        // accelerate
        animator.acceleration = 17;
    });
    primaryStage.setScene(scene);
    primaryStage.show();
}