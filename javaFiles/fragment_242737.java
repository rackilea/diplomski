if(args.length > 3 || args.length == 0) {
    System.out.println("number of arguments invalid");
} else {
    double mult = 1.0;
    try {
        for (String arg : args) {
            mult *= Double.parseDouble(arg);
        } 
   } catch (...) { 
       // your message 
   } 
   System.out.println(mult);
}