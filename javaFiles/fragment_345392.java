public void ShootBullet()
    {
        double bulletVelocity = 1.0; //however fast you want your bullet to travel
        //mouseX/Y = current x/y location of the mouse
        //originX/Y = x/y location of where the bullet is being shot from
        double angle = Math.Atan2(mouseX - originX, mouseY - originY);
        double xVelocity = (bulletVelocity) * Math.Cos(angle);
        double yVelocity = (bulletVelocity) * Math.Sin(angle);
    }