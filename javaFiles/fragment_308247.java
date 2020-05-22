public static void main(String args[]) throws Exception {
    String s = "abc_xyz abc 123 1 + 1";
    StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(s));
    tokenizer.ordinaryChar('-'); // Don't parse minus as part of numbers.
    tokenizer.ordinaryChar('/'); // Don't parse slash as part of numbers.
    tokenizer.wordChars('_', '_'); // Don't parse slash as part of numbers.


    List<String> tokBuf = new ArrayList<String>();
    while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) //While not the end of file 
    {
        switch (tokenizer.ttype) //Switch based on the type of token
        {
        case StreamTokenizer.TT_NUMBER: //Number
            tokBuf.add(String.valueOf(tokenizer.nval));
            break;
        case StreamTokenizer.TT_WORD: //Word
            tokBuf.add(tokenizer.sval);
            break;
        default: //Operator
            tokBuf.add(String.valueOf((char) tokenizer.ttype));
        }
    }
    System.out.println(tokBuf);
}

run:
[abc_xyz, abc, 123.0, 1.0, +, 1.0]