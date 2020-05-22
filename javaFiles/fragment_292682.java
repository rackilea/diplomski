String[] rl = { "Afghanistan(+ff93)", "Afghanistan(+93)", "Afghanistan(+493)", "Afghanistan(+454593)" };

        for (String country : rl) {

            StringTokenizer tokenizer = new StringTokenizer(country , "()");
            tokenizer.nextToken();
            String codeVal = tokenizer.nextToken();
            System.out.println(codeVal);

        }