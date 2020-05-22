//here your reading the unit value as ex: 190
 unit=input.nextInt(); 

 if (unit >= 1 && unit <= 200) {
        //here your changin the  unit value to 190 * 8 so now unit value is 1520
        unit = unit * 8;
        System.out.println(" bill of 200 units is " + unit);
  }
 //now here your given value is 190 but unit value is changed to 1520    here condition true, that is the reason second condition also excecuting.
 if (unit > 501) {
        extra = unit - 500;
        System.out.println("unit consumed  " + extra + "  that above");
        extra = extra * 25;
        System.out.println("------------unit above 500 bill-------- \n"
                + extra);
        total_unit = 200 * 8 + 100 * 10 + 100 * 15 + 100 * 20 + extra;
        System.out
                .println("---------total bill----------\n  " + total_unit);
    }