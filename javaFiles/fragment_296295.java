public static void Sorting(int[] sort, int a, int con){
if(a<0)return;
int j, count=0;
for(j=1; j<=con; j++){
  if(sort[a]==sort[j])
   count++;
}System.out.println(sort[a]+" occurs "+count+" times"); 
Sorting(sort, a-1, con);