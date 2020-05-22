ArrayList<Double> yourArray = new ArrayList<>();
final String FILENAME = "sample.txt";
            list.add(arrayValue)
            try ( BufferedWriter bw = new BufferedWriter (new FileWriter (FILENAME)) ) 
            {           
                for (Double line : yourArray) {
                    bw.write (line + "\n");
                    bw.newLine();
                }

                bw.close ();

            } catch (IOException e) {
                e.printStackTrace ();
            }