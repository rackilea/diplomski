String input = "sjoen aer varmt idag kanske kommer vi att simma daer. "
        + "Det aer vaeldigt roligt att simma daer. "
        + "Min mamma säger till mig att daer aer alltid kallt och att aaka tid tar mycket tid.";
String output = "sjön är varmt idag kanske kommer vi att simma där. "
        + "Det är väldigt roligt att simma där. "
        + "Min mamma säger till mig att där är alltid kallt och att åka tid tar mycket tid.";

input = input.replace("aa", "å").replace("ae", "ä").replace("oe", "ö");

System.out.println(input);
//prints
//sjön är varmt idag kanske kommer vi att simma där. 
//Det är väldigt roligt att simma där. 
//Min mamma säger till mig att där är alltid kallt och att åka tid tar mycket tid.
System.out.println(input.equals(output));//true