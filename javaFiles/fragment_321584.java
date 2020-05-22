public class FileHandlerManager {

    public static void processFile(File file, List<FileHandler> handlers) {

        // ... Setup your scanFile from your file... leaving this out.

        while (scanFile.hasNextLine()) {

            String currentLine = scanFile.nextLine();

            String[] allWordsInCurrentLine = currentLine.split(" ");

            for (FileHandler handler : handlers) {
                handler.handle(allWordsInCurrentLine);
            }
        }
    }
}