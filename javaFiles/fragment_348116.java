// Option 2: including subtypes of the allowed types
  public boolean isErlaubt(Geraet pGeraet) {
    for(Class<? extends Geraet> clazz : mErlaubt){
      if (clazz.isAssignableFrom(pGeraet.getClass())) {
        return true;
      }
    }
    return false;
  }