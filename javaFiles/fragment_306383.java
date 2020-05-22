void display(){
    pushMatrix();
    translate(width/2,height/2);

    pushMatrix();
    translate(posX,posY);
    rotate(radians(angle));

    fill(255);
    stroke(255);
    imageMode(CENTER);
    image(c,0,0,wrap,wrap);
    popMatrix();

    line(0,0,posX,posY);
    popMatrix();
}