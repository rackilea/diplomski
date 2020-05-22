while ((inputData = input.readLine()) != null) {
        if(inputData.length() != 0) {
          StringTokenizer tokenizer = new StringTokenizer(inputData, ";");
          String id = tokenizer.nextToken();
          String StnFrom = tokenizer.nextToken();
          String NorthingTo = tokenizer.nextToken();
          String EastingDistBrg = tokenizer.nextToken();
          String StdError = tokenizer.nextToken();

          if (id.equalsIgnoreCase("C")) {
            C++;
            outC.println(StnFrom + " " + NorthingTo + " " + EastingDistBrg);
          } else if (id.equalsIgnoreCase("B")) {
            B++;
            outB.println(StnFrom + " " + NorthingTo + " " + EastingDistBrg + " " + StdError);
          } else if (id.equalsIgnoreCase("D")) {
            D++;
            outD.println(StnFrom + " " + NorthingTo + " " + EastingDistBrg + " " + StdError);
          }
        }
      }