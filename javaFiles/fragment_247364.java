double dx = (mx-vx); // change in x from head to mouse
double dy = (my-vy); // change in y from head to mouse
double dist = Math.sqrt(dx*dx + dy*dy); // distance, pythagorean theorem
double degrees = Math.toDegrees((Math.acos(dy/dist)) * -Math.signum(dx));
        // dy/dist is the cosine
        // the sign of dx determines positive (CCW) or negative (CW) angle