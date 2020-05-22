public CSVReader(Reader in, int buflen, String file) throws IOException {
    this.buf = new char[buflen];
    this.pos = 0;
    this.len = in.read(buf, 0, buf.length);
    this.tmp = new String[1000];
    this.in = in;
    this.separator = ','; // default
    this.file = file;