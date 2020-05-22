final double[] k = new double[3];
  for (int i=0; i<5; i++) {
    for (int j = 0; j < 3; j++) {
      System.out.println ("Bitte geben sie die " + 
          (j == 1? "ers" : j == 2? "zwei" : "drit") +
          "te Koordinat der "+(i+1)+". Vektor ein");
      k[j] = scan.nextDouble();
    }
    vektor.add(new Vektor3Dcomparable(k[0], k[1], k[2], i));
  }