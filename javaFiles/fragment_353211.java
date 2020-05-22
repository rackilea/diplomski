public ClassName() throws IOException{
        // the path to your file is relative to the package of ClassName
        InputStream input = ClassName.class.getResourceAsStream("big.txt"); 

        BufferedReader inp = new BufferedReader(new InputStreamReader(input));

        // some code

        inp.close();        
}