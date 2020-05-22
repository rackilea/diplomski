try(BufferedReader data = new BufferedReader(new FileReader(roadFile));) {
            String line = null;
            String delim = "\t";
            while((line = br.readLine()) != null){
                StringTokenizer tok = new StringTokenizer(line, delim);
                while(tok.hasMoreTokens()){
                    String nextToken = tok.nextToken();
                    //do stuff with the nextToken String
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }