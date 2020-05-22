Data data = new Data();
data.setDate(dateString);
System.out.println(data.getDate()); //THIS WILL PRINT dateString CORRECTLY


Data data2 = new Data();
System.out.println(data2.getDate()); //THIS WILL NOT, BECAUSE THIS INSTANCE DOES NOT HAVE THE date VARIABLE SET!!!