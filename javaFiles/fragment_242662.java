FileReader reader;
        try {

            reader = new FileReader("Student.txt");

            BufferedReader br = new BufferedReader(reader); 

             JTextArea area = new JTextArea();


                area.read(br,null);
                br.close();

             area.requestFocus();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException ioe) {
            // TODO Auto-generated catch block
            ioe.printStackTrace();
        }