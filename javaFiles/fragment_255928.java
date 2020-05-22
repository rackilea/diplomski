int MAX_HEIGHT = 100;
int MAX_WIDTH = 100;
int NUM_POINTS = 6;


// Generate random list of points
List<Point> pointList = new List<Point>();

Random rand = new Random();

for(int i = 0; i < NUM_POINTS ; i++)
{
    pointList.add(new Point(rand.nextInt(MAX_HEIGHT), rand.nextInt(MAX_WIDTH));
}

BinaryTree tree = CreateKDTree(pointList, 0);


// Recursive function for creating a K-D Tree from a list of points
// This tree can be used to draw lines that divide the space up
// into rectangles.
public BinaryTree CreateKDTree(List<Point> pointList, int depth)
{
    // Have to create the PointComparator class that just selects the
    // specified coordinate and sorts based on that
    Coordinate coord= depth % 2 == 0 ? X_COORDINATE : Y_COORDINATE
    Collections.sort(pointList, new PointComparator(coord));

    int median = pointList.size() / 2;

     // unfortunately Java doesn't have a BinaryTree structure so
     // you have to create this too
    BinaryTree node = new BinaryTree(pointList[median]);

    if(pointList.size() == 1) return node;

    if(median > 0)
        node.left(CreateKDTree(pointList.subList(0, median), depth + 1);

    if(median + 1 < subList.size())
        node.right(CreateKDTree(pointList.subList(median + 1, subList.size()), depth + 1);

    return node; 
}