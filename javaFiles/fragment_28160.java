public class ThisClass {
private static final URL path =      ThisClass.class.getResource("TextFile.info");
private static final String TEXTFILE = path.getFile();

private String name;
private int loadingBays;
private int containerHandlingTime;
private int storageCapacity;

public ThisClass(String name, int loadingBays, int containerHandlingTime,
                 int storageCapacity) {
    this.name = name;
    this.loadingBays = loadingBays;
    this.containerHandlingTime = containerHandlingTime;
    this.storageCapacity = storageCapacity;


}

public static void main(String[] args) throws FileNotFoundException, IOException {
    BufferedReader br = null;
    FileReader fr = null;

    String sCurrentLine;

    br = new BufferedReader(new FileReader(TEXTFILE));

    String name = "";
    int loading = 0;
    int time = 0;
    int capacity = 0;

    int count = 1;

    int elemCount = 0;

    ThisClass[] classArray = new ThisClass[2];

    while ((sCurrentLine = br.readLine()) != null) {

        System.out.println("sCurrentLine = " + sCurrentLine);
        if (sCurrentLine.toLowerCase().startsWith("name")) {
            name = sCurrentLine.split(":")[1].trim();
        } else if (sCurrentLine.toLowerCase().startsWith("loading")) {
            loading = Integer.parseInt(sCurrentLine.split(":")[1].trim());
        } else if (sCurrentLine.toLowerCase().startsWith("container")) {
            time = Integer.parseInt(sCurrentLine.split(":")[1].trim().replace("ms", ""));
        } else if (sCurrentLine.toLowerCase().startsWith("storage")) {
            capacity = Integer.parseInt(sCurrentLine.split(":")[1].trim());
        }
        if (count % 4 == 0) {
            classArray[elemCount] = new ThisClass(name, loading, time, capacity);
            elemCount += 1;

            System.out.println("name = " + name);
            System.out.println("loading = " + loading);
            System.out.println("time = " + time);
            System.out.println("capacity = " + capacity);
        }


        if (!sCurrentLine.trim().equalsIgnoreCase(""))
            count += 1;
    }

    for (ThisClass cl : classArray) {
        System.out.println("cl = " + cl);
    }
}

@Override
public String toString() {
    return "name: " + this.name
            + "loadingBays: " + this.loadingBays
            + "handlingTime: " + this.containerHandlingTime
            + "capacity: " + this.storageCapacity;
}