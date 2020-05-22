for (int page = 0; page < pageCount; page++)
                    {
        stripper.setStartPage(0);
        stripper.setEndPage(page + 1);
        stripper.writeText(parser.getPDDocument(), outString);
        Vector vectorlistoftps = stripper.getCharactersByArticle();
        PDPage thisPage = stripper.getCurrentPage();
        for (int i = 0; i < vectorlistoftps.size(); i++) {
                List<TextPosition> tplist = vectorlistoftps.get(i);
        }
    }