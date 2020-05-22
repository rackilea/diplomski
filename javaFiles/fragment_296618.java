private boolean testSolution(Position p, Position prior, List<Position> visited){
   //return true, if our current Position solves the problem
   if (visited.contains(p)){
     return true;
   }

   //this is now visited
   visited.add(p);

   //Else: Check, which options we have at the current position
   //and check if one of the neighbors is a valid solution.
   for (Position nextP : getNeighborsOf(p)){
      if (prior == null || !nextP.equals(prior)){
         if (testSolution(nextP, p, visited)){
            //this satisfies the condition!
            //we hit a position we visited a while ago but not exactly in 
            //the prior step. -> theres at least one loop.
            return true;
         }else{
            //check next neighbor for the current position
            // (no code required)
         }
      }else{
        //moving back would end in an infinite loop. avoid that.
        // (no code required)
      }
   }

   //no neighbor working? return false to return to the "prior"
   //position, so it can evaluate other options.
   return false;
}