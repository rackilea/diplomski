NavigableSet<Param> pset = new TreeSet<Param>();

  Param p1 = new Param(10, 20);
  Param p2 = new Param(20, 30);
  Param p3 = new Param(30, 50);
  Param p4 = new Param(50, 60);

  pset.add(p1);
  pset.add(p2);
  pset.add(p3);
  pset.add(p4);

  System.out.println(pset);      

  int sdiff = -2;
  int ediff = 2;      

  //Find the item we want, as well as the preceding and succeeding items
  Param p = pset.floor(new Param(20, 30));      
  Param lower = pset.lower(p);
  Param higher = pset.higher(p);      

  //Remove the item from the set and modify it
  pset.remove(p);
  p.start += sdiff;
  p.end += ediff;      

  //Add only if it is valid
  if(p.start < p.end) {
      pset.add(p);    
  }      

  //If we have a preceding item
  if(lower != null) {
      //Remove, modify, and add back to set
      pset.remove(lower);
      lower.end += sdiff;
      if(lower.start < lower.end) {
          pset.add(lower);
      }    
  }

  //Same case as lower
  if(higher != null) {
      pset.remove(higher);
      higher.start += ediff;          
      if(higher.start < higher.end) {
          pset.add(higher);
      }    
  }

  System.out.println(pset);