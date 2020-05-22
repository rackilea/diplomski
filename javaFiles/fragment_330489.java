public static void main(String[] args) throws ParseException{
        BufferedReader br = null;

        try {

                String sCurrentLine;
                br = new BufferedReader(new FileReader("C:\\path\testing.txt"));
                SnowballStemmer stemmer = (SnowballStemmer) new frenchStemmer();

                while ((sCurrentLine = br.readLine()) != null) {

                        String[] tokens = sCurrentLine.split(" ");    
                        for (String string : tokens) {
                            stemmer.setCurrent(string);
                            stemmer.stem();
                            String stemmed = stemmer.getCurrent();

                            System.out.println(stemmed);
                        }
                }

        } catch (IOException e) {
                e.printStackTrace();
        } finally {
                try {
                        if (br != null)br.close();
                } catch (IOException ex) {
                        ex.printStackTrace();
                }
        }        
    }