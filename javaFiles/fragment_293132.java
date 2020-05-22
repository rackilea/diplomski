Random rand = new Random(438976);   // initialize pseudo-random generator with an arbitrary seed

Point size = screenMetrics();   // so screenMetrics() is called only once
int xSize = size.x; 
int ySize = size.y;

for(int i = 0; i < num; i++) {
    point.x = rand.nextInt(xSize);   // from 0 (inclusive) to xSize (exclusive) 
    point.y = rand.nextInt(ySize);   // from 0 (inclusive) to ySize (exclusive)

    shape = rand.nextInt(3);   // from 0 (inclusive) to 3 (exclusive)


// ...
}