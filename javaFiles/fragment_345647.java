public Bar getBar() {
       Bar bar = new Bar();
       bar.setPropOne(this.getPropOne());
       bar.setPropTwo(this.getPropTwo());
       return bar;
  }