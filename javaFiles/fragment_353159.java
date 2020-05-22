class Box{

    // [...]

    void collide(Box o){    
        if(x < o.x+o.w  && o.x < x+w && y < o.y+o.h && o.y < y+h){
            c = color(255, 255, 255);
        }
    }
}