// These should be constants, defined at the class level
public static final int NUM_RECTANGLES = 13;
public static final int NUM_COLUMNS = 4;

// And your loop
int col = 0;
int row = 0;
for(int i = 0; i < NUM_RECTANGLES; i++)
{
    Graphics.fillRect((col * 15), 10 + (row * 15), 10, 10);
    col++;
    if( col == NUM_COLUMNS ) {
        col = 0;
        row++;
    }
}