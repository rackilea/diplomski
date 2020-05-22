public static void main(String[] args)
{
    for(int i=0; i<25; i++){
       arrayList[i] = i + 1;   
       if ((i+1) % 5 != 0)
            System.out.print(arrayList[i]+",");
        else
            System.out.println(arrayList[i]);
    }
}