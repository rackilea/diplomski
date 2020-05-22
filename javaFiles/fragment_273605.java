public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("EEEE:HH:mm", Locale.ENGLISH);

public static void main(String[] args) throws ParseException, FileNotFoundException {
    // you can read from, to, filePath from args

    Date from = DATE_FORMAT.parse("Sunday:08:00");
    Date to = DATE_FORMAT.parse("Sunday:09:00");

    Collection<Item> items = readItems(new File("pathToInputFile"));
    Collection<Item> filtered = filterItems(items, from, to);
    // do something with your filtered items
}

public static Collection<Item> readItems(File inputFile) throws FileNotFoundException, ParseException {
    Scanner scanner = new Scanner(inputFile);

    Collection<Item> items = new ArrayList<>();
    while (scanner.hasNext()) {
        String[] split = scanner.next().split(":");
        if (split.length < 4) {
            continue; // incomplete row, skip or maybe throw exception?
        }
        Date date = DATE_FORMAT.parse(split[1] + ":" + split[2] + ":" + split[3])
        items.add(new Item(split[0], date));
    }
    return items;
}


// This is for Java 7, if you are using Java 8+, you can use lambdas for filtering
public static Collection<Item> filterItems(Collection<Item> items, Date from, Date to) {
    Collection<Item> filtered = new ArrayList<>();
    for (Item item : items) {
        long millis = item.getDate().getTime();
        if (millis >= from.getTime() && millis <= to.getTime()) {
            filtered.add(item);
        }
    }
    return filtered;
}