for (int j = 0; j < args.length; j++) {
   for (int i = 0; i < args.length - j; i++) {
       int currentNumber = args[i];
       if (i + 1 < args.length) {
         if (currentNumber > args[i + 1]) {
            args[i] = args[i + 1];
            args[i + 1] = currentNumber;
         }
       }
   }
}