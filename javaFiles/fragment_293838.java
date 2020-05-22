for(int i=1; i<submenuCap.toString().length();i++){
     String[] parts = captionRes.getString(i).split("[*]");
     if(parts.length >1){ // check added.
        String part1 = parts[0]; 
        String part2 = parts[1];
        System.out.println("First parts: "+part1+" 2nd Part: "+part2);
     }
 }