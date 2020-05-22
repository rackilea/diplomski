ArrayList < Evidence > setOfEvidence = new ArrayList < > (evidenceBoxList);
    for (Evidence e: setOfEvidence) {
      if (this.getCaseNumber() == keyNumber) {
        if (this.getCaseName().equals(keyName)) {
          System.out.println("Pieces of DNA Evidence in Evidence Box number " + this.getCaseNumber() + " found by " + this.getCaseName() + ": " + this.getEvidence());
          getEvidence().add(e);
        } else {
          System.out.println("Not found!");
        }
      } else {
        System.out.println("Not Found!");
      }
    }
    return getEvidence();
  }