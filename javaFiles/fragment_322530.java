if (change.wasUpdated()) {
      String inj = (data.get(change.getFrom()).injured.getValue())?"injuried":"no longer injuried";
      System.out.println(data.get(change.getFrom()).lastName.getValue() + ", " + 
              data.get(change.getFrom()).firstName.getValue() + "  "
              + "changed his status to " + inj);
      System.out.println();  
  }