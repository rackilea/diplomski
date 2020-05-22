new Thread(){

  public void run(){
             final Process process = Runtime.getRuntime().exec(dosCommand + " " + location);
             final InputStream in = process.getInputStream();

             int ch;
             while((ch = in.read()) != -1) {
                System.out.print((char)ch);
                /* ... etc */
             }

  }

}.start();