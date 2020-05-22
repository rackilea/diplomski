PathMeasure pm = new PathMeasure(myPath, false);
//coordinates will be here
float aCoordinates[] = {0f, 0f};

//get coordinates of the middle point
pm.getPosTan(pm.getLength() * 0.5f, aCoordinates, null);