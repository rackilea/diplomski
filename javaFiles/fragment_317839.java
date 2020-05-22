ArrayList<Kanji> kanjis = readFile();
    if (kanjis != null) {
        for (Kanji kanji : kanjis) {
            System.out.println("kunyomi:  " + kanji.get_kunyomi()[0]);
            System.out.println("onyomi:  " + kanji.get_onyomi()[0]);
            System.out.println("significado:  "
                    + kanji.get_significado()[0]);
            System.out.println("unicode:  " + kanji.get_unicode()[0]);
        }
    }