public static void createData(BufferedReader br, String token, int size, Adif2Record record) throws IOException {
    StringBuilder sb = new StringBuilder(size);
    for (int i = 0; i < size; i++) {
        int c = br.read();
        if (c == -1) {
            throw new IOException("Unexpected end of input");
        }
        sb.appendCodePoint((char) c);
    }
    record.setData(token, sb.toString());
}

private List<Adif2Record> records = new ArrayList<>();

public void read() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(filePath));

    int intValue;
    boolean createToken = false;
    boolean createSize = false;
    boolean createType = false;
    StringBuilder token = new StringBuilder();
    StringBuilder size = new StringBuilder();
    Adif2Record record = new Adif2Record();

    while ((intValue = br.read()) != -1) {
        switch (intValue) {
            case '\n':
                break;
            case '<':
                createToken = true;
                break;
            case ':':
                if (createToken) {
                    // not in header
                    createToken = false;
                    createSize = true;
                } else if (createSize) {
                    createType = true;
                    createSize = false;
                }
                break;
            case '>':
                switch (token.toString().toLowerCase()) {
                    case "eor":
                    case "eoh":
                        records.add(record);
                        record = new Adif2Record();
                        break;
                    default:
                        createSize = false;
                        createType = false;
                        createData(br, token.toString(), str2int(size.toString()), record);
                }
                token.setLength(0);
                size.setLength(0);
                break;
            default:
                char cValue = (char) intValue;
                if (createToken) {
                    token.append(cValue);
                }
                if (createSize) {
                    size.append(cValue);
                }
                if (createType) {
                    // TODO
                }
        }

    }

}

private static int str2int(String s) {
    return s.isEmpty() ? 0 : Integer.parseInt(s);
}