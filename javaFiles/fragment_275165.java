//init
int i = 0; 
final int N = 60;
Point[] data=new Point[N];
for(i=0;i<N;i++)data[i]=new Point();//dummy points to start with

//update
void addPoint(Point p){
   data[i] = p;
   i = (i+1)%N;
}