public class program45{
    public static void main(String args[]){
        int count1=0,num1=0;
        for (int num=1; num<=1000; num++ ){
            int count=0
            for(int facnum=1; facnum<=num; facnum++){
                if(num%facnum==0){
                    count++;
                }
            }
            if(count>count1){
                num1=num;
                count1=count;
            }
        }
        System.out.println(num1+" has the most factors");
        System.out.print("they are ");
        for(int facnum1=1; facnum1<=num1; facnum1++){
            if (num1%facnum1==0){
                System.out.print(facnum1+", ");
            }
        }
    }
}