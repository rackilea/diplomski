Context Context;
AssetManager mngr = context.getAssets();
String line;
        try {

            BufferedReader br = new BufferedReader(new FileReader(mngr.open("words.txt")));
            if (!br.ready()) {
                throw new IOException();
            }
            while ((line = br.readLine()) != null) {
                words.add(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }