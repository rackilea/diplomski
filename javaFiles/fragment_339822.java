public static void main(String[] args)
{
    String s = "My favorite pet 43 is 12 cat 32 ";
    String split[] = s.split(" ");
    int sum=0;
    for(String str:split){
        try{
            int temp=Integer.parseInt(str);
            sum+=temp;
        }catch(Exception e){
            //
            continue;
        }
    }
    System.out.println(sum);
}