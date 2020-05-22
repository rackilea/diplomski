Slide slide = hslf.createSlide();
 int rows = 0;
 int maxRowsPerSlide = 10; // Tune this

 for(MyRowThingy row : getMeMyRows()) {
     doAddRowToSlide(row, slide);

     rows++;
     if(rows % maxRowsPerSlide == 0) {
        // Slide is full, time for a new slide!
        slide = hslf.createSlide();
     }
 }