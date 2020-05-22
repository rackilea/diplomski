class StringParser {
     final StringReader sr;
     public StringParser(String text) {
          sr = new StringReader(text);
     }

     public String next(int n) {
          char[] chars = new char[n];
          sr.read(chars);
          return new String(chars);
     }

     public String nextAsLong(int n) {
          return Long.parseInt(next(n));
     }
}

StringParser sp = new StringParser("FF7900002481201132570943440402151302961500080054021E000040FFFFFBFF79000024812011");
sp.next(8); // ignored
long first= sp.nextAsLong(2);
long second = sp.nextLong(10);
// etc