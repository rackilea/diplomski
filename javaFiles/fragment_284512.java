boolean magicDone=false;
  public String getMagicValue() {
       if (!magicDone){
           magicDone=true;
           genMagicValue();
       }
       return this.magicValue();
  }