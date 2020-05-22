public class patt {
    static int ar[]={2,6,12,20,30,42};
    static int length=ar.length;
    public static void pattern(){
        int y=0,x=0;
        while( x<ar.length){
            int c[]=new int[6];

                    if(x+1>=length){
                break;
            }
            else{
            c[x]=ar[x+1]-ar[x];
            System.out.print(c[x]+" ");
            ar[x]=c[x];
        }
            x++;
            }
            System.out.println();
        length--;


    }


    public static void main(String args[]){
    patt ob=new patt();
    System.out.println("2 6 12 20 30 42");
for(int a=0;a<6;a++){
    ob.pattern();
}
}
}