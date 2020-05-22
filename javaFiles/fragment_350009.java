void setup(){
    size(600,600);  
    frameRate(10);
}

int i=1;   
void draw(){
    background(196);
    func(str(i),100,200,30);
    i ++;
}

void func(String s,int x,int y,int size){
    fill(0);  
    textSize(size);
    text(s,x,y);
    return;
}