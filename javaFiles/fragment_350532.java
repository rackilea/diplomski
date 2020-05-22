public void process(Processor processor, int x1, int y1, int x2, int y2) {
    int dy = Math.abs(y2 - y1);
    int dx = Math.abs(x2 - x1);
    if (dx<=dy) {
        if (dy==0) {
            // Case A
            processor.process(x1, y1);
            return;
        }
        // Cases B, C, D, E, and F
        if (y2>y1) processVertically  (processor, x1, y1, x2, y2, dy - dx);
              else processVertically  (processor, x2, y2, x1, y1, dy - dx);
    } else {
        // Cases G, H, and I
        if (x2>x1) processHorizontally(processor, x1, y1, x2, y2, dx - dy);
              else processHorizontally(processor, x2, y2, x1, y1, dx - dy);
    }
}

private void processVertically(Processor processor, int x1, int y1, int x2, int y2, int h) {
    if (x2<x1) {
        // Cases E and F
        // Fill in parallelogram 
        int y = y2;
        for (int x=x2; x<=x1; x++) {
            for (int dy=0; dy<=h; dy++)
                processor.process(x, y-dy);
            y--;
        }
        // Fill in triangles
        for (h-=2; h>=0; h-=2) {
            x1++; y1++;
            x2--; y2--;
            for (int dy=0; dy<=h; dy++) {
                processor.process(x1, y1+dy);
                processor.process(x2, y2-dy);
            }
        }
    } else {
        // Cases B, C and D
        // Fill in parallelogram 
        int y = y1;
        for (int x=x1; x<=x2; x++) {
            for (int dy=0; dy<=h; dy++)
                processor.process(x, y+dy);
            y++;
        }
        // Fill in triangles
        for (h-=2; h>=0; h-=2) {
            x1--; y1++;
            x2++; y2--;
            for (int dy=0; dy<=h; dy++) {
                processor.process(x1, y1+dy);
                processor.process(x2, y2-dy);
            }
        }
    }
}

private void processHorizontally(Processor processor, int x1, int y1, int x2, int y2, int w) {
    if (y2<y1) {
        // Case G
        // Fill in parallelogram 
        int x = x2;
        for (int y=y2; y<=y1; y++) {
            for (int dx=0; dx<=w; dx++)
                processor.process(x-dx, y);
            x--;
        }
        // Fill in triangles
        for (w-=2; w>=0; w-=2) {
            x1++; y1++;
            x2--; y2--;
            for (int dx=0; dx<=w; dx++) {
                processor.process(x1+dx, y1);
                processor.process(x2-dx, y2);
            }
        }
    } else {
        // Cases H and I
        // Fill in parallelogram 
        int x = x1;
        for (int y=y1; y<=y2; y++) {
            for (int dx=0; dx<=w; dx++)
                processor.process(x+dx, y);
            x++;
        }
        // Fill in triangles
        for (w-=2; w>=0; w-=2) {
            x1++; y1--;
            x2--; y2++;
            for (int dx=0; dx<=w; dx++) {
                processor.process(x1+dx, y1);
                processor.process(x2-dx, y2);
            }
        }
    }
}