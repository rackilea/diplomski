public void moveImage (){
            int dx = 0;
            int dy = 0;
            if(dynamics[0]) dx -= 2; 
            if(dynamics[1]) dy -= 2; 
            if(dynamics[2]) dx += 2; 
            if(dynamics[3]) dy += 2; 
            p.move((int)p.getX() + dx, (int)p.getY() + dy);
            repaint();
        }