while((slovo = reader.readLine()) != null){
        tokenizer = new StringTokenizer(slovo, " //.//,");
        while(tokenizer.hasMoreTokens()) {
            slovo = tokenizer.nextToken();
            seznamSlov.add(new Slovo(slovo));
        }
    }