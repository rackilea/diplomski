StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new FileReader("foo.in")));

while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {

                if (tokenizer.ttype == StreamTokenizer.TT_WORD)
                    // use tokenizer.sval
                else if (tokenizer.ttype == StreamTokenizer.TT_NUMBER)
                   // use tokenizer.nval
            }