Queue<Point> points = new ArrayBlockingQueue<Point>(1024);
for(int i=0;i<1000;i++)
  points.add(new Point(i,i));
Point missing = new Point(-1, -1);
int runs = 100 * 1000;
long start = System.nanoTime();
for(int i=0;i< runs;i++)
    points.contains(missing);
long time = System.nanoTime() - start;
System.out.printf("Average contains() took %.1f us%n", time/runs/1000.0);