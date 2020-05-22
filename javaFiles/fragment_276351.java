interface Monsters {
    …
}

interface MonstersFactory {
    public Monsters create();
}

enum StockMonstersFactory implements MonstersFactory {
    CRAWLER("Crawler", 15, 5, 100, 3),
    HOWLER( "Howler", 20, 10, 50, 4),
    PROWLER( "Prowler", 30, 15, 150, 5),
    MANTIS( "Mantis", 40, 20, 200, 8),
    GOLEM("Golem", 60, 25, 300, 10),
    DOGS( "Group of Dogs", 10 ,5, 40, 2 );

    private StockMonstersFactory(String name, /*…other initialization options…*/) {
        //…
        //standard initializer, set enum constants to what you need them