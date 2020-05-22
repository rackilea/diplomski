Car forza;
Trees tr;
float wrap = 100;

void setup(){
    size(800,800);
    forza = new Car();
    tr = new Trees();
}

void draw(){
    background(0);
    forza.update();
    forza.display();
    tr.road();
}

class Car {

    float posX;
    float posY;
    float speed;
    float accel;
    float angle;
    PImage c;

    Car(){
        posX = 0;
        posY = 0;
        speed = .9;
        angle = sin(0);
        accel = 0;
        c = loadImage("car.jpg");
    }

    void update(){
        if (keyPressed) {
          if (key == 'd') {
            angle += 1;
          }else if (key == 'a'){
            angle -= 1;
          } else if (key == 'w'){
            posX += speed;
          } else if (key == 's'){
            posX -= speed;
          }
        }  
    }

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
}

class Trees {
    float x;
    float y;

    Trees(){
      //x = random(0,);
    }

    void trash(){

    }
    void road(){
      fill(250,50);
      rectMode(CENTER);
      rect(width/2,height/2, width/2, height);
    }

    void show(){

    }
}