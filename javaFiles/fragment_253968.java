import java.util.*;
import java.io.*;
class SO{
    public static void main(String...a)throws Exception{
        System.out.println("Start");


//Read thing
File f = new File("so_data.txt");

Scanner s = new Scanner(f);

int counts = 0;

s.nextLine();//skip 1
s.nextLine();//skip 2
s.nextLine();//skip 3
counts = Integer.parseInt(s.nextLine().split(" ")[2]);//use 4th
s.nextLine();//skip 5
s.nextLine();//skip 6
System.out.println(counts+" : counts");



counts = 6;//DUMMY DATA FOR TEST FILE - REMOVE FOR ACTUAL FILE

Coordinate[] xy = new Coordinate[counts];


int i = 0;

while(i<counts){ // picking exactly the required number of items.

            String line = s.nextLine();
            String[] vals = line.split(" ");

            double x = Double.parseDouble(vals[1]);
            double y = Double.parseDouble(vals[2]);

            Coordinate c =  new Coordinate(x,y);
//          System.out.println(c);
            xy[i++] = c;
        }


for( i = 0;i<xy.length;i++)
            System.out.println("for index "+i+") "+xy[i]);

    }
}
 class Coordinate {
    double x;
    double y;
    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "Coord:: "+x+" , "+y;
    }
}