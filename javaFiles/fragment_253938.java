@Override
public void draw(Graphic g){        
    if  (this.health > 50){
        g.setColor(green);
    }else{
        g.setColor(red);
    }
    super.draw(g); // if you want to call the parent draw and just change color
}