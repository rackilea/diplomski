Cursor c = myDataBase.rawQuery("select *, 'くん' as tipo " +
            "from Kunyomi, " +
            "VocabularioKun " +
            "where Kunyomi._id = VocabularioKun.idKunyomi " +
            "and Kunyomi.idKanji = 18" +
            " union " +
            "select *, 'おん' as tipo " +
            "from Onyomi, " +
            "VocabularioOn  where  Onyomi._id = " +
            "VocabularioOn.idOnyomi and Onyomi.idKanji = 18", null);