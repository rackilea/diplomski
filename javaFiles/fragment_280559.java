class Permutation { 

    static LinkedList<String> output= new LinkedList<>(); //<---for storing result 

  public void permute(String str, int l, int r){ 
    if (l == r) {
    //   System.out.println(str);

        output.addLast(str); //<----store it in the linkedlist
    }
    else{ 
      for (int i = l; i <= r; i++){ 
        str = swap(str,l,i); 
        permute(str, l+1, r); 
        str = swap(str,l,i); 
      } 
    }

  }