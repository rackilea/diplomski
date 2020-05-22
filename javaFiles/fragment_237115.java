String[] tokens = read.split("\\|");
for (String token : tokens) {
   String[] params = token.split(":");
   Integer a = Integer.parseInt(params[0]);
   Integer b = Integer.parseInt(params[1]);

   // ...

}