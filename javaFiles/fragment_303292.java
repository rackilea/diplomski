public static void main(String[] args) throws IOException {

    Stack stack = new Stack();
    Queues queue = new Queues();

    File stackfile = new File("stack.txt");

    if (!stackfile.exists()) {
        stackfile.createNewFile();
    } else {
        System.out.println("File is done");
    }
    FileReader r = new FileReader(stackfile);
    BufferedReader reader = new BufferedReader(r);

    String line = null;

    // Skip headline
    reader.readLine();

    while ((line = reader.readLine()) != null) {

        String[] splitLine = line.trim().split("#");

        if (splitLine.length == 3)
            stack.Push(new Data(splitLine[1], splitLine[2], splitLine[0]));
    }

    reader.close();

    File queuefile = new File("queue.txt");

    if (!queuefile.exists()) {
        queuefile.createNewFile();
    } else {
        System.out.println("File is done");
    }

    BufferedReader read = null;
    read = new BufferedReader(new FileReader(queuefile));

    // Skip headline
    read.readLine();

    while ((line = read.readLine()) != null) {

        String[] splitLine = line.trim().split("#");

        if (splitLine.length == 3)
            queue.insert(new Data(splitLine[1], splitLine[2], splitLine[0]));
    }

    read.close();

}