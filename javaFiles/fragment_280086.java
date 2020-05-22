String str = 
        "Some message I want to split 'but keeping this a\\'s a single string' Voila!";

String[] toks = str.split( " +(?=((.*?(?<!\\\\)'){2})*[^']*$)" );
for (String tok: toks)
    System.out.printf("<%s>%n", tok);