for(int i=start;i<=end;i++){      // here i might be last valid index, i.e. 4 in your example     
    if(heights[i] > heights[i++]){    //here i might be 5 (because of i++), i.e. you'd get the ArrayIndexOutOfBoundsException     
       difference =heights[i] - heights[i++]; //here i might be 6 (because of another i++), i.e. you'd get the ArrayIndexOutOfBoundsException                 
    }else if(heights[i++] > heights[i]){     //here i might be 5, i.e. you'd get the ArrayIndexOutOfBoundsException    
       difference =heights[i++] - heights[i];            
    }   
    total+=difference;   
  }