public Stack( Stack aStack ) {
    System.arraycopy(aStack.Sarray,0,this.Sarray,0,aStack.Sarray.length);
    // By the way: please start members with a small letter!

    this.nrElem = aStack.nrElem;
}