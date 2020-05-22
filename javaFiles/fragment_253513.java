public void trickleUp(int index, Node bottom){       
        int parent=(index-1)/2;
        if(index>0 && heapArray[parent].getKey()>bottom.getKey()){
            heapArray[index]=heapArray[parent];          
            trickleUp(parent, bottom);
        }   
        else{
          heapArray[index]=bottom;
        }
    }