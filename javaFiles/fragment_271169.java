/*
    To start and for convenience, set each elements's
    id to its own index value
*/

//number of elements to test
int n; 

int[] treeSize = new int[n];
int[] id = new int[n];
for(int i = 0; i < n; i++){
    id[i] = i;
    treeSize[i] = 1;
}

void makeUnion(int p, int q){
    /*
       Connect smaller tree to the bigger one by
       making root of the smaller tree the child of
       the root of the bigger tree.
    */
    int pRoot = getRoot(p);
    int qRoot = getRoot(q);

    treeSize[pRoot] < treeSize[qRoot] ?
      id[pRoot] = qRoot, treeSize[qRoot] += treeSize[pRoot] :
      id[qRoot] = pRoot, treeSize[pRoot] += treeSize[qRoot] ;
}

bool connected(int p, int q){
  return getRoot(p) == getRoot(q);
 }

int getRoot(int i){
   /*
     Transverse through parent
     pointers in the tree
     until root is reached
   */
   while(i != id[i]){         //check if root
      id[i] = id[ id[i] ];  //flatten tree a bit(path compression by 1/2) points to grand-parent now
      i = id[i];                          //move up one level
   }
   return i;
}