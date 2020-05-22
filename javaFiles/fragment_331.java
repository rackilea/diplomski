public class Earnings {

final static String START_TRIGGER = " Some text I would like not to inclcude";
final static String STOP_TRIGGER = " Some text I would like not to inclcude";

enum ProcessingState {
    NOT_READY,
    READY,
    FINISHED;
}

public static void main(String[] args) throws FileNotFoundException {

    Scanner scanner = new Scanner(new FileReader("Example.txt"));

    TreeMap<String, String> map = new TreeMap<String, String>();

    ProcessingState processingState = ProcessingState.NOT_READY;

    while (scanner.hasNextLine() && processingState != ProcessingState.FINISHED) {

        String lineToProcess = scanner.nextLine();

        if (processingState == ProcessingState.READY && lineToProcess.startsWith(STOP_TRIGGER))
            processingState = ProcessingState.FINISHED;

        if (processingState == ProcessingState.READY) {
            String[] columns = lineToProcess.split(",");
            map.put(columns[0],columns[1]+", "+columns[2]);
        }

        if (processingState == ProcessingState.NOT_READY && lineToProcess.startsWith(START_TRIGGER))
            processingState = ProcessingState.READY;


    }

    System.out.println(map);
}

}