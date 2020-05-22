import java.util.Scanner;
 public class HelloWorld{
 public static int i=0;
 public static String num[]={"first","second","third","fourth"};
 public static boolean taken[]={false,false,false,false};
 static String[] choicelist={"","","",""};
 public static String queryChoices(String[] choices){
    HelloWorld h=new HelloWorld();
    int l;    
    String ch;
    Scanner s=new Scanner(System.in);
    if(i<3){
        System.out.println("enter your "+num[i]+" choice:\n The choices are");
        for(int j=0;j<4;j++){
            if(!taken[j])
                System.out.println(j+". "+choices[j]);
        }    
        int n=s.nextInt();
        taken[n]=true;
        h.choicelist[i]=choices[n];
        ch=choices[n];
        i++;
    }else{
        for(l=0;l<4;l++){
            if(!taken[l])
            break;
        }
        h.choicelist[3]=choices[l];
        ch=choices[l];
    }
   return ch; 

 }
 public static void main(String []args){
    String[] choices={"a","b","c","d"};

    String choice=queryChoices(choices);
    System.out.println("your choice is: "+ choice);
    System.out.println("your choice is: "+ choicelist[0]);

 }
}