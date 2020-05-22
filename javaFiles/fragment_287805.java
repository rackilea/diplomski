base = 8;
      int leng  = 20;
      int pleng =  4;

      array = new int [pleng];

      makeParts(0,array.length-1);

      num = 0;
      stick = new int [leng / pleng];
      stickParts(0, (leng/pleng) - 1);

      out.print(String.format("Got %d numbers\n", num));