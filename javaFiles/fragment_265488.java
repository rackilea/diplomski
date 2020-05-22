double theta = Math.atan2(yy-y,xx-x);
  //theta is now in the range -Math.PI to Math.PI
  if(theta<0)
     theta = Math.PI - theta;
  //Now theta is in the range [0, 2*pi]
  //Use this value to determine which slice of the circle the point resides in.
  //For example:
  int numSlices = 8;
  int whichSlice = 0;
  double sliceSize = Math.PI*2 / numSlices;
  double sliceStart;
  for(int i=1; i<=numSlices; i++) {
      sliceStart = i*sliceSize;
      if(theta < sliceStart) {
          whichSlice = i;
          break;
      }
  }
  //whichSlice should now be a number from 1 to 8 representing which part of the circle
  // the point is in, where the slices are numbered 1 to numSlices starting with
  // the right middle (positive x-axis if the center is (0,0).