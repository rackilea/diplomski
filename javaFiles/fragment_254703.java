// This is so you don't get index out of bounds errors if the lists are different lengths.
   // You could combine these into one line with nested Math.min calls.
   // I made it two lines to be easier for you to read.
   int minListLength = Math.min(shakeInsults1.length, shakeInsults2.length);
   minListLength = Math.min(minListLength, shakeInsults3.length);

   for (int s = 0; s < minListLength; s++) {

          String randElement1 = shakeInsults1[rand.nextInt(shakeInsults1.length)];       

          String randElement2 = shakeInsults2[rand.nextInt(shakeInsults2.length)];

          String randElement3 = shakeInsults3[rand.nextInt(shakeInsults3.length)];

          System.out.println("Thou ", + randElement1, ", " + randElement2 + ", " + randElement3 + ".");

  }