import java.util.*;
         class CUBE {   

        public static void main(String[] args)   {              /*gives a series of consecutive odd numbers                                          
                                       whose sum is equal to the input value.  
                                       input is a cube of a number less than 1000*/

                int i,odd,t,sum,cube,n; 
                String c="y"; 
                System.out.println("c is : " + c);
                Scanner sc=new Scanner(System.in);        

                do
                {
                    i=1;
                    odd=1;
                    t=2;
                    sum=0;
                    System.out.println("\nEnter the cube");
                    cube=sc.nextInt(); //input is stored in 'cube'
                    CUBE myCube = new CUBE();
                    n=myCube.cubeRoot(cube);  /*'n' is the cube root of 'cube'. If 'cube'  
                                         is not a perfect cube then n=0*/


                  while(i<=n) 

                    {
                        sum+=odd;  //consecutive odd numbers are are added in sum    
                       if(sum==cube) //loop stops if sum=cube
                        {
                            break;
                        }
                        else if(i==n && sum!=cube)
                        {
                            i=1; //counter goes back to 1
                            sum=0;
                            odd=i+t; //odd becomes the next odd number just after 1 and then the one after that
                            t+=2;
                        }
                        else
                        {
                            i++; 
                            odd+=2;
                        }
                    }
                    if(n!=0) //if 'cube' is a perfect cube then n will never be 0
                    {
                       System.out.print("\n"+cube+" = ");
                       for(i=1;i<=n;i++,odd-=2) //i gives the required odd numbers of the series
                       {
                             System.out.println(i);
                       }
                       System.out.println("\nTry again? (Y/N)\n"); 
                       Scanner sc2=new Scanner(System.in);                                 
                       c=sc2.nextLine();
                    } 
                }
                while(c.equals("y")||c.equals("Y"));//if c is "y" then loop should run again but it doesnt
            }


            int cubeRoot(int cube)  {                    /*returns the cube root of 
                                                          cube and returns 0 if its 
                                                          invalid */

                int i;
                for(i=1;i<=1000;i++)//n sholud be less than 1000
                {
                    if(i*i*i==cube) //if i^3 = cube then n=i
                      return i;
                }
                System.out.println("\nINVALID INPUT.");//prints if cube is not a perfect cube 
                return 0;
            }}