for(int i=start;i<end;i++){   
int next = i + 1;     
    if(heights[i] > heights[next]){  
       difference =heights[i] - heights[next]; //assuming you mean next = i + 1 here and not next = i + 2 like in your code               
    }else if(heights[next] > heights[i]){    
       difference =heights[next] - heights[i];            
    }   
    else {
      difference = 0; //due to public demand I'll help you with this, too
    }

    total+=difference;   
  }