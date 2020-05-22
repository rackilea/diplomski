Point [] points0={new Point(137,139),new Point(50,63),new Point(78,5)};
Point [] points1={new Point(147,139),new Point(60,63),new Point(79,5)};
Point [] points2={new Point(157,139),new Point(70,63),new Point(80,5)};

void setup(){
  Point[][] pointLists = {points0,points1,points2};
  Recognizer r = new Recognizer(pointLists);
}

class Point{
  float x,y;
  Point(float x,float y){
    this.x = x;
    this.y = y;
  }
  String toString(){
    return "Point("+x+","+y+")";
  }
}
class Recognizer{
  Point[][] data;
  Recognizer(Point[][] data){
    this.data = data;
    for(int i = 0 ; i < data.length; i++){
      println("processing points list" + i);
      for(int j = 0; j < data[i].length; j++){
        println("processing point["+j+"] of list " + i + " : "+data[i][j]);
      }
    }
  }
}