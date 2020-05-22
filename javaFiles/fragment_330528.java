void linearPoints (float w1, float b){
    strokeWeight(3);
    stroke(100,100,255);
    float x0 = -width;
    float x1 = width;
    float y0 = x0 * w1 + b;
    float y1 = x1 * w1 + b;
    line(x0+width/2, -y0+height/2, x1+width/2, -y1+height/2);
}

void axes(){
    strokeWeight(1);
    stroke(255,100,0);
    line(0,height/2, width, height/2);
    line(width/2, 0, width/2, height);
}