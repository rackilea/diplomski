ftf2.setInputVerifier(new InputVerifier() {
  public boolean verifyText(String textToVerify) {
     Pattern p = Pattern.compile("your regexp");
     Matcher m = p.matcher(textToVerify);
        if (m.matches()) {
        setComponentValue(textToVerify);
        return true;
    }
    else {
        return false;
    }

  }
});