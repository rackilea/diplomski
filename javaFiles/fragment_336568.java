public static void findLeaves(Tree root, List<Tree> leaves){

        //iterate over children 
        for(Tree child : root.children2) { //better use getter 

            //if child has no children it is a leaf. Add it to list 
            if(! hasChildren(child))  leaves.add(child);
            //if child has children, check them 
            else  findLeaves(child, leaves);
        }

        return ;
  } 

  static boolean hasChildren(Tree child) {

      for(int i=0; i < child.children2.length; i++) {

          if(child.children2[i] != null) return true;
      }
      return false;
  }