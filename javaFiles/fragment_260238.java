public static void mergeFiles(String target, String... input) throws IOException {
    String lineBreak = System.getProperty("line.separator");
    PriorityQueue<Map.Entry<String,BufferedReader>> lines
        = new PriorityQueue<>(Map.Entry.comparingByKey());
    try(FileWriter fw = new FileWriter(target)) {
        String header = null;
        for(String file: input) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            if(line == null) br.close();
            else {
                if(header == null) fw.append(header = line).write(lineBreak);
                line = br.readLine();
                if(line != null) lines.add(new AbstractMap.SimpleImmutableEntry<>(line, br));
                else br.close();
            }
        }
        for(;;) {
            Map.Entry<String, BufferedReader> next = lines.poll();
            if(next == null) break;
            fw.append(next.getKey()).write(lineBreak);
            final BufferedReader br = next.getValue();
            String line = br.readLine();
            if(line != null) lines.add(new AbstractMap.SimpleImmutableEntry<>(line, br));
            else br.close();
        }
    }
    catch(Throwable t) {
        for(Map.Entry<String,BufferedReader> br: lines) try {
            br.getValue().close();
        } catch(Throwable next) {
            if(t != next) t.addSuppressed(next);
        }
    }
}