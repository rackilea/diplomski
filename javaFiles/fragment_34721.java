String number = "R$123.456.789,0";
number = number.replace(".", "");
number = number.replace(",", "."); //put this second so the previous line won't wipe out your period
number = number.replace("R", "");
number = number.replace("$", "");

//two ways you can do this. either create an instance of DecimalFormat, or call it anonymously.
//instance call:
DecimalFormat df = new DecimalFormat("#.##");
//now parse the number and feed it to your decimal formatter
number = df.format(Double.parseDouble(number));

//anonymous call:
number = new DecimalFormat("#.##").format(Double.parseDouble(number));

//output test:
System.out.println(number);