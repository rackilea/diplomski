String toBeParsed = "src:expr[src:call[src:name[src:name='m']]]]" +        
        "[src:call[src:name[src:operator='.']]]]" +
        "[src:call[src:name[src:name='getDisplayFormat']]]]" +
        "[src:call[src:argument_list='()']]][src:operator='instanceof']]" +
        "[src:name='MathFormat']]";
System.out.println(toBeParsed.replaceAll("(]+)]", "$1"));