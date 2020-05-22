this.speed = 60.0;
this.deltaTime = 0.0001;
this.endTime = 10.0;
this.x = 1.0;
this.y = 10;
this.ay = -9.8;
this.ax = 0;
this.angle = 45;
this.vx = this.speed*Math.cos(this.angle*(Math.PI/180.0))
this.vy = this.speed*Math.sin(this.angle*(Math.PI/180.0))

double time = 0.0;
while (time < this.endTime){
    time += this.deltaTime;
    this.x += this.vx*this.deltaTime;
    this.y += this.vy*this.deltaTime;

    this.vx += this.ax*this.deltaTime;
    this.vy += this.ay*this.deltaTime;
}