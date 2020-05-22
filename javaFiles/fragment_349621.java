public boolean isValid() {

    validate = false;

    boolean fooCond = (foo == 0) || (foo == myfoo);
    boolean barCond = (bar == 0) || (bar == mybar);
    boolean foobarCond = (foobar == 0) || (foobar == myfoobar);
    boolean foofooCond = (foofoo == null) || foofoo.equals(myfoofoo);
    boolean barbarCond = (barbar == null) || mybarbarlist.contains(barbar);
    boolean foobarfoobarCond = (foobarfoobar == null) || foobarfoobar.equals(myfoobarfoobar);

    if (fooCond
          && barCond
          && foobarCond
          && foofooCond;
          && barbarCond
          && foobarfoobarCond) {
        validate = true;
    }

    return validate;
}