while (m.find()) { 
     String forReadStr=m.group(); 
     //If the end of the token is a double quote, Do this  
     //in this loop, you can then declare anything for the lexeme you detected and do anything with it
            if(forReadStr.endsWith("\"")){            
                 System.out.println(m.group()+"\n\t -> \t This is a String Literal\n");
            }
}