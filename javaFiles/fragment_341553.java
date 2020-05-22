while(input.hasNextLine()) {
     String line = input.nextLine();
     String[] tokens = input.split(" ,");
     String name = tokens[0];
     int age = Integer.valueOf(tokens[1]);
     String gender = tokens[2];
     if (tokens.length > 3) {
         int salary = Integer.valueOf(tokens[3]);
         ...
     }
}