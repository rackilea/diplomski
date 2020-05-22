System.out.printf("  %04.2f",12.6542);   output ==> 12.65
       System.out.printf("  %+04.2f",12.6542);  output ==> +12.65(plus sign here bcoz we gave +)
       System.out.printf("  %+04.2f",-12.6542); output ==> -12.65

       System.out.printf("  %02d",1);   output ==> 1 
       System.out.printf("  %02d",1);   output ==> 01 (bcoz of 02d) 
       System.out.printf("  %03d",1);   output ==> 001 (bcoz of 03d)


       System.out.printf("  %+04.2f",22.2);     output ==> +22.20
       System.out.printf("  %+04.2f",2222.125); output ==> +2222.13 
       (left side of decimal is never truncated . so all chars shows ie total 6 chars even though only 4 asked 

       System.out.printf("  %+04.0f",2222.125); output ==> +2222 (bcoz zero chars requested after decimal point)