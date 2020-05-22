public static void main (String[] args) throws java.lang.Exception
{
int ml[] = {1,2,3,4,5,6,7,8,9};
int val = -2;
ArrayList al = new ArrayList();
if(val>0){
for(int i = 0 ; i<ml.length;i+=val){
    al.add(ml[i]);
}
}
else if(val<0){
for(int i = ml.length-1 ;  i>=0; i+=val){
    al.add(ml[i]);
}   

}


for(int i = 0 ; i<al.size();i++){
    System.out.println(al.get(i));
}

}