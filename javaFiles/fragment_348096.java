public class Math extends StudentCharts {

public Math(){
math = new String [3][3];
math[0][0]="math";      math[0][1]="Bill Gates";    math[0][2]="49";   
math[1][0]=math[0][0];  math[1][1]="John Doe";      math[1][2]="12";   
math[2][0]=math[0][0];  math[2][1]="Paul Allen";    math[2][2]="31";  }

public void prnt (String namechk){
    int x=0;
    int y=0;
   **boolean namesmatch=false;**

    for (x=0; x<3; x++) {
       **if (namechk.equalsIgnoreCase(math[x][1]))** {
           for (y=0; y<3; y++) {
        System.out.print(math[x][y]+" ");
        **namesmatch=true;**
    } } }
            if (!namesmatch) {
        System.out.println("error");
   } } }