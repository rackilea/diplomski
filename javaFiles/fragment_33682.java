import java.util.Arrays;

ArrayList<Point> points0 = new ArrayList<Point>(Arrays.asList(new Point[]{new Point(137,139),new Point(50,63),new Point(78,5)}));
ArrayList<Point> points1 = new ArrayList<Point>(Arrays.asList(new Point[]{new Point(147,139),new Point(60,63),new Point(79,5)}));
ArrayList<Point> points2 = new ArrayList<Point>(Arrays.asList(new Point[]{new Point(157,139),new Point(70,63),new Point(80,5)}));

void setup(){
  ArrayList<ArrayList<Point>> pointLists = new ArrayList<ArrayList<Point>>();
  pointLists.add(points0);
  pointLists.add(points1);
  pointLists.add(points2);
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
  ArrayList<ArrayList<Point>> data;
  Recognizer(ArrayList<ArrayList<Point>> data){
    this.data = data;
    for(int i = 0 ; i < data.size(); i++){
      println("processing points list" + i);
      for(int j = 0; j < data.get(i).size(); j++){//write this in a nicer way, too many get calls, might want a reusable variable here
        println("processing point["+j+"] of list " + i + " : "+data.get(i).get(j));
      }
    }
  }
}