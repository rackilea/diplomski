color [][][]array = new color[10][10][10];
int x = 0;
int y = 0;

void setup(){
  size(1100,1000);
  background(0);
  for(int i= 0; i < 10; i++){
    for(int j= 0; j < 10; j++){
      for(int k= 0; k < 10; k++){
        array[1][j][k] = color(i*25.5,j*25.5,k*25.5);
      }
    }
  }
}
void draw(){
  background(0);
  strokeWeight(0);
  stroke(0);
  for(int s= 0; s < 10; s++){
    x= 110*s;
    y= 110*s;
    for(int v= 0; v < 10; v++){
      for(int t= 0; t < 10; t++){
        fill(array[s][v][t]);
        ellipse(x+t*10+5,v*10+5,10,10);
      }
    }
  }

}