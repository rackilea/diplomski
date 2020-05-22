import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Keys {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/resources/META-INF/keys"));
        scanner.useDelimiter("\n");

        Map<String, EntryInfo> stats = new HashMap<>();
        int lineCount = -1;
        while(scanner.hasNext()){
            final String current = scanner.next();
            lineCount++;
            if(StringUtils.isEmpty(current)){
                continue;
            }

            EntryInfo currentEntryInfo = stats.containsKey(current) ? stats.get(current) : new EntryInfo(lineCount);
            currentEntryInfo.incrementCount();
            stats.put(current, currentEntryInfo);
        }
        scanner.close();

        for (String key : stats.keySet()) {
            System.out.println(key + " (" + stats.get(key) + ")");
        }
    }

    public static class EntryInfo{
        private int count = 0;
        private int firstLine = 0;
        public EntryInfo(final int firstLine) {
            this.firstLine = firstLine;
        }
        public void incrementCount() {
            this.count++;
        }
        @Override
        public String toString() {
            return "Count : " + this.count + " First line : " + this.firstLine;
        }
    }
}