public OuterBuilder {
     // some outer attributes here

     private ArrayList<MiddleBuilder> m_middleList;

     public OuterBuild( mandatory params for Outers ){
          // populate some outer attributes
          // create empty middle array
     }

     public addMiddle(MiddleBuilder middler) {
              m_middleList.add(middler);
     } 
 }