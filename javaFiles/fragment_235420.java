vx = speed*Math.cos(angle);
vy = speed*Math.sin(angle);
dx = vx*dt;
dy = vy*dt;
x += dx;  // movement in x-direction after dt time w/ constant velocity
y += dy;  // movement in y-direction after dt time w/ constant velocity