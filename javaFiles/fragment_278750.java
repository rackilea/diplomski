class A{
    float x;
    float y;
    PApplet myPApplet;
    public A(float x, float y, PApplet myPApplet){
        this.x = x;
        this.y = y;
        this.myPApplet = myPApplet;
    }
    public void draw(){
        myPApplet.ellipse(x,y,10,10);
    }
}

class B extends PApplet{
    A a = new A(12,19, this);
    public void draw(){
        ellipse(25,25,25,25);
        a.draw();
    }
}