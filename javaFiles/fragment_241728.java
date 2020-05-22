import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input,inputstorage,lengthstorage,inputlength;
    int nonrep=0;
    System.out.println("Enter the number of values");
    int n = sc.nextInt();
    int fmedian=0,smedian=0;
    System.out.println("Enter a value");
    input= sc.next();                                                                 //String
    inputlength = "" + (char)(input.length()+48);
    inputstorage = input;
    lengthstorage = inputlength;
    for (int i=1; i<n; i++)
    {
        System.out.println("Enter a value");
        input = sc.next(); 
        inputstorage = inputstorage + input;
        lengthstorage = lengthstorage + (char)(input.length()+48); 
    }                

    int mainnumpos = 0;

    for(int j=0;j<n;j++)
    {
      int copy=0;
      int mainnumlength = lengthstorage.charAt(j) - 48;
        int neg=0,pos=0;
        int mainnum = 0; int factor = 1;int mainnumsign = 0;
        for (int m =mainnumlength-1; m >= 0; m--)
        {
        if(inputstorage.charAt(mainnumpos+m)=='-')
        {
          mainnumsign = 1;
        }
        else
        {
        mainnum += (inputstorage.charAt(mainnumpos+m) - '0') * factor;
        factor *= 10;
        }
        }
        mainnumpos = mainnumpos + mainnumlength;
        if(mainnumsign==1)
        {
          mainnum = -mainnum;
        }

        int position = 0;
        for (int q=0;q<n;q++)

      { int fnumsign = 0;


      int fnumlength = lengthstorage.charAt(q) - 48;

        int fnum = 0;
        factor = 1;
        for (int l =fnumlength-1; l >= 0; l--)
        {
          if(inputstorage.charAt(position+l)=='-')
          {
            fnumsign = 1;
          }
          else{
        fnum += (inputstorage.charAt(position+l) - '0') * factor;
        factor *= 10;
          }
        }
        if(fnumsign==1)
        {
          fnum = -fnum;
        }
        if((mainnum-fnum)>0)
        {
          pos++;
        }
        else if((mainnum-fnum)<0)
        {
          neg++;
        }
        else{
          copy++;
            }
        position = position + fnumlength;



      }

      if((n%2)!=0){

     if((double)(pos+copy)>=((double)n)/2.0 && (double)(neg+copy)>=((double)n)/2.0)
     {
       if(nonrep==0)
       {
       System.out.println("The median is: "+ mainnum);
       nonrep++;
       }                           
     }
     }
     else
     {
       if ((double)(pos+copy)==(double)n/2.0) 
       {
         fmedian=mainnum;
       }
       else if((double)(neg+copy)==(double)n/2.0) 
       {
         smedian = mainnum;
       }
       else if((double)(pos+copy)>=(double)n/2.0 && (double)(neg+copy)>=(double)n/2.0  ) 
       {
         fmedian = mainnum;
         smedian = mainnum;
       }
       if(j==n-1){
         double evenmedian = ((double)(smedian + fmedian))/2.0;
       System.out.println("The median is: "+evenmedian);
       }
     }
    }

  }
}