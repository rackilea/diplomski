boolean isFirst = true;

public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawImage(ship, ship_dx, ship_dy, this);
    if(isLaser){
        laser_dy -= laser_velocity;
        if(isFirst){

            laser_dx = ship_dx+laser_DxOffSetOfBall;
            isFirst = false;

        }
        g.drawImage(laser,laser_dx,laser_dy,this);
        if(laser_dy < 50)
        {
            isLaser = false;
            laser_dy = ship_dy-laser_DyOffSetOfBall;
        }
    } else {
        isFirst = true;
    }
        Toolkit.getDefaultToolkit().sync();
}