import java.util.*;  
class yearst
{  

    static int a[]={0,31,28,31,30,31,30,31,30,31,30,31,30}; 

    static int i=1,s,s1=0,s2=0,s3=0,k,diy=365,m,m1,m2,d1,d2,y1,y2,y;

     static void leap(int y)
        {
        if(y%4==0 && y%100!=0 || y%400==0) //for leap year
        {
            a[2]=29;
            diy=366;
        }
         else
         { 
            a[2]=28;
            diy=365;

        }
        }


        public static void main(String args[])
        {
            //i=1;s1=0;s2=0;s3=0;diy=365;

        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the months,dates and years");
        m1=ob.nextInt();
        m2=ob.nextInt();
        d1=ob.nextInt();
        d2=ob.nextInt();
        y1=ob.nextInt();
        y2=ob.nextInt();
        for(i=y1;i<y2;i++)
        {
            leap(i+1);
            m=1*diy;
            s1=s1+m;
        }

        for(i=1;i<m1;i++)//no of days left in y1
        {
            leap(y1);
            s2+=a[i];
        }
        s2+=d1;
        k=diy-s2;
        for(i=1;i<m2;i++)//no of days passed
        {
          leap(y2);
          s3+=a[i];
        }
        s3+=d2;
        s=s1+s2+s3;
        System.out.println("No of days in between"+s);
    }
}