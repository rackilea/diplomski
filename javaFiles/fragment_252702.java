BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 List<Entry> collectedData = new ArratList<>();

    do
    {
        Entry entry = new Entry();
        System.out.println("Enter Day of Sale (Sunday, Monday, Tuesday, etc.): ");
        entry.dayName = br.readLine();
        System.out.println("Enter Sale Amount: ");
        entry.value  = Integer.parseInt(br.readLine(), 7);
        collectedData.add(entry);
        System.out.println("Are you finished entering sales? (Y/N)");

        System.out.println(text);
        System.out.println(a);
        if (br.readLine().startsWith("y"))
        {
        } else
        {
            break;
        }
    }

for(entry : collectedData) {
    System.out.println(entry.dayName + ": " + entry.value);
}

public class Entry {
    String dayName;
    Integer value;
}