@Override
   public int read() {
       int r = this.inputStreamReader.read();
       this.foo.submit(r);
       return r;
   }