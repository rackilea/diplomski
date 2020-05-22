public static void main(String[] args) {
        try {
          BufferedReader br = new BufferedReader(new FileReader("nej.txt"));
          String line = null;

          List < CD > cdsList = new ArrayList < > ();

          while ((line = br.readLine()) != null) {
            CD cd = new CD();
            String tmp[] = line.split(",");
            cd.setArtist(tmp[0]);
            cd.setTitel(tmp[1]);

            if (tmp.length > 2) {
              cd.setGenre(tmp[2]);
              cd.setRecordcompany(tmp[3]);
              cd.setYear(Integer.parseInt(tmp[4].trim()));
              cd.setSongs(Integer.parseInt(tmp[5].trim()));
              cd.setplaytime(Double.parseDouble(tmp[6].trim()));

            }
            cdsList.add(cd);

          }
          System.out.println(cdsList);

          br.close();

        } catch (IOException e) {
          System.out.println(e);
        }

}