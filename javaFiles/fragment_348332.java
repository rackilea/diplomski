String in = "synchronized public final static native void main(String[] args)";
String out = in.replaceAll(
      "(?:\\b"
    +   "((?:public|protected|private)\\s+)|((?:abstract|static)\\s+)|"
    +   "(final\\s+)|((?:volatile|synchronized)\\s+)|((?:native|strictfp)\\s+)"
    + ")+",
  "$1$2$3$4$5"
);

System.out.println(out);// public static final synchronized native void main(String[] args)