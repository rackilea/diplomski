//As long as we have elements to modify
while(lower != null) {
    Param nextLower = null;

    //Remove, modify, and add back to set if valid
    pset.remove(lower);
    lower.end += sdiff;

    if(lower.start < lower.end) {
        //The modified slice is valid, so add it back
        pset.add(lower);                   
    } else if(lower.start > lower.end) {
        //The modified slice is not valid and so we're not
        //going to add it. But it looks like we might have
        //encroached on the space of the slice that precedes
        //"lower" (at least; we may have extended past even
        //more, possibly all the way up to and past the
        //beginning)
        nextLower = pset.lower(p);
        if(nextLower != null && p.start == nextLower.start) {
            //It looks like we took up the space of the preceding
            //slice exactly (i.e., we are flush against it) and
            //so we don't need to do anything.
            nextLower = null;
        } else if(nextLower != null) {
            //It looks like we took up the space of the preceding
            //slice and then some. Let's adjust sdiff to reflect
            //that.
            sdiff = p.start - nextLower.end;                  
        }                            
    }

    lower = nextLower;
}

  //Similar to lower
  while(higher != null) {
      Param nextHigher = null;

      pset.remove(higher);
      higher.start += ediff;

      //Need to check for the additional case where the modified element's
      //end time could supersede a "higher" element's end time.
      if(higher.start < higher.end && higher.end > p.end) {
          pset.add(higher);              
      } else if(higher.start > higher.end || higher.end <= p.end) {
          nextHigher = pset.higher(p);
          if(nextHigher != null && p.end == nextHigher.start) {
              nextHigher = null;
          } else if(nextHigher != null) {
              ediff = p.end - nextHigher.start;                  
          }
      }

      higher = nextHigher;
  }