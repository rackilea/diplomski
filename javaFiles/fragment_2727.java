int getIndexOfMinimalLevel(Node root){
  ArrayList<Node> todo = new Arraylist(); //Nodes of the current level
  ArrayList<Node> done = new ArrayList(); //Nodes processed

  int minLevel = 0;  //index of the current minimal level
  int currLevel = 0; //index of the current level
  int minLevelSum = root.value; //sum of values of the nodes of the minimal level
  todo.add(root); //current level contains only the root node

  while(todo.size()>0){ //while there are nodes of this level
    int currLevelSum = 0; //sum of the values of nodes of this level
    for(int i=0; i<todo.size(); i++){ //for each node in this level
      currLevelsum+=todo.get(0).value; //add his value to sum
      done.add(todo.remove(0)); //remove it and put it in the done list
    }
    if(currLevelSum < minLevelSum){ //if this level has the lowest sum since now
      minLevel = currLevel; //the minimal sum level index is the index of this level
      minLevelSum = currLevelSum //the lowest sum is the sum of the values of the nodes of this level
    }
    Node tmp;
    for(int i=0; i<done.size(); i++){ //for every node processed
      tmp=done.get(0);     
      if(tmp.left!=null){     //if it has a left child
        todo.add(root.left);  //add it to the todo list
      }
      if(root.right!=null){   //if it has a right child
        todo.add(root.right); //add it to the todo list
      }
      done.remove(0);         //remove it from the done list
    }
    currLevel++;
  }
  return minLevel;
}