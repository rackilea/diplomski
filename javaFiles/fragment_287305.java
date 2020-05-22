if (XYcoords.size() != 0) {
   // check to see if we aren't trying to add the same DotView reference
   // (meaning we are still inside the same DotView)
   int lastId = XYcoords.get(XYcoords.size() - 1);
   if (lastId != endView.getId()) {
      // not the same DotView so add it
      XYcoords.add(endView.getId());
   } 
} else {
   XYcoords.add(endView.getId()); // first event, must add it
}