public String toString(){
     String ans = ""; 
     for(int i = 0; i < this.length; i++){
          ans += this.get(i) + " ";
          if(i % 5 == 0)
              ans += "\n";
     }
     return ans;
 }