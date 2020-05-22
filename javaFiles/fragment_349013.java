String output ;
    for(String s: books[0]){
      output = output +s+ ",";
    }
output = output.substring(0, output.length()-1);
System.out.print(output);