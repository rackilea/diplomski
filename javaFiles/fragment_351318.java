int reverse = 0;   

for(int i=0;i<array.length;i++)
for(int j=0;j<array.length;j++)
      {
          if(i%2 == 0){
            if(j == 0){
                inc = reverse;
                if(i > 0 )inc = inc + num + 1;
            }
            array[i][j]=inc;
            inc++;  
          }
          else{
              if(j == 0)reverse = inc + num - 1;
              array[i][j]=reverse;
              reverse--;
          }
      }