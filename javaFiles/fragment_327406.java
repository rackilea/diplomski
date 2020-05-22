@Override
public void move(long dt)
{
    double dt_s = dt / 1e9;
    double dx_m = speed * dt_s;


    double left_wall = 0;
    double right_wall = board.x1_world;

    x += dx_m;
    if (x <= 0) speed *= -1.0;
    if (x >= right_wall) speed *= -1.0;
}