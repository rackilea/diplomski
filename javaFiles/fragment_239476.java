public int open() {
   if (!condition)
        return super.open();    // as usual
    else
        return CANCEL;
}