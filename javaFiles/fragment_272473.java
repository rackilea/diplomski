FileWriter fstream = new FileWriter("fileName");
        BufferedWriter fbw = new BufferedWriter(fstream);

        while ((line = in.readLine()) != null) {

            fbw.write(line + "\n");

        }