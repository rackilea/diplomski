FileWriter fw = null;
BufferedWriter bw = null;
PrintWriter out = null;
try{

        fw = new FileWriter("database.txt", true);
        bw = new BufferedWriter(fw);
        out = new PrintWriter(bw);

                    out.println(nctext.getText());
                    out.flush();
                    out.close();


   } catch (IOException e) {
                   e.printstacktrace();}