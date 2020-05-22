BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(path));
                String line = null;


            while ((line = br.readLine()) != null) {
                //here you have to load your table 

            }

        } catch (IOException e) {
            //manage your exceptions
        } finally {
            try {
                if (br != null){
                               br.close(); // close open streams resources
                            }
            } catch (IOException ex) {
                //manage your exceptions
            }
        }