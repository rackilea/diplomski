String csv =
        "22/09/2011 15:15:11 \"AT45 - Km 2 +300   Foo \" \"PL - 0460\" 70 096 123456_110922_151511_000001M.jpg 123456 \"DBx 4U02\" 428008 100 95 \"AB123CD\"\n" +
        "22/09/2011 15:15:16 \"AT45 - Km 2 +300   Foo \" \"PL - 0460\" 70 087 123456_110922_151516_000002M.jpg 123456 \"DBx 4U02\" 428008 100 95 \"EF456GH\"\n" +
        "22/09/2011 15:16:30 \"AT45 - Km 2 +300   Foo \" \"PL - 0460\" 70 079 123456_110922_151630_000005M.jpg 123456 \"DBx 4U02\" 428008 200 96 \"LM789NP\"";

CSVParser parser = new CSVParserBuilder().withSeparator(' ').build();

CSVReader reader = new CSVReaderBuilder(new StringReader(csv))
        .withCSVParser(parser)
        .build();

for (String[] row : reader){
    for (String str : row){
        System.out.println(str);
    }
    System.out.println("----");
}