// Init a new array.
for(int i=0;i<len-1;i++)
{        
    if((a[i] - a[i+1]) == 0)
       continue;         // for skipping repeated number in outer loop 
    for(int j=i+1;j<len;j++)
    {
        if((a[i]+a[j])==m ) {
            System.out.println(a[i]+" "+a[j]);
            break;             // for skipping repeated number in inner loop
        }
      else if(a[i] == m/2){
        System.out.println(a[i]+" "+a[i]);
        break;
      }
    } 

}