Random rand = new Random(438976);   // initialize pseudo-random generator with an arbitrary seed

Point size = screenMetrics();   // so screenMetrics() is called only once
int xSize = size.x; 
int ySize = size.y;

Vector<Integer> generated = new Vector<Integer>(0);    
for(int i = 0; i < num; i++) {
    point.x = rand.nextInt(xSize);   // from 0 (inclusive) to xSize (exclusive) 
    point.y = rand.nextInt(ySize);   // from 0 (inclusive) to ySize (exclusive)

    while (true) {
        shape = rand.nextInt(3);   // from 0 (inclusive) to 3 (exclusive)
        if (!generated.Contains(shape)){
            generated.add(shape);
            break;
        }
        else if (generated.size() == 3) {
            generated.clear();
            break;
        }
    }

// ...
}