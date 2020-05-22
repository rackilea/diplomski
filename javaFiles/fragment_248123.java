try {
            Document doc = Jsoup.connect("http://multiplayer.it/articoli/")
                    .get();
            Elements sezioni = doc.getElementsByClass("archive_box");
            for (Element riga : sezioni) {

                Element info = riga.getElementsByClass("text").first();

                String titolo = riga.getElementsByTag("h2").first().text();
                System.out.println(titolo);

                String date = info.getElementsByClass("date").first().text();
                System.out.println(date);

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }