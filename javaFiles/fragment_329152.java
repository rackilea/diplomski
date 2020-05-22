/**
 *
 * @author youans
 */
public class SubtitleCorrector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String fileContent = null;
            File inFile = new File("/IN_DIRECTORY/Test Video Bad Format.srt");
            BufferedReader br = new BufferedReader(new FileReader(inFile));
            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append("\n");
                    line = br.readLine();
                }
                fileContent = sb.toString();
            } finally {
                br.close();
            }
            String ragex = "\\d{2}:\\d{2}:\\d{2},\\d{3}";
            List<String> slotsTiming = new ArrayList(new TreeSet(getAllMatches(fileContent, ragex)));

            System.out.println(slotsTiming.size());

            String timingRagex = "(((^1\n)|(\\n\\d+\n))(\\d{2}:\\d{2}:\\d{2},\\d{3}.*\\d{2}:\\d{2}:\\d{2},\\d{3}))";
            ragex = timingRagex + "[A-Za-z-,;'\"\\s]+";

            List<String> subtitleSlots = getAllMatches(fileContent, ragex);
            List<String> textOnlySlots = new ArrayList();

            for (String subtitleSlot : subtitleSlots) {
                textOnlySlots.add(subtitleSlot.replaceAll(timingRagex + "|\n", ""));
            }
            StringBuilder sb = new StringBuilder("");

            for (int i = 0; i < textOnlySlots.size(); i++) {
                sb.append((i + 1)).append("\n").append(slotsTiming.get(i)).append(" --> ").append(slotsTiming.get(i + 1)).append("\n").append(textOnlySlots.get(i)).append("\n\n");
            }

            File outFile = new File("/OUT_DIRECTOR/" + inFile.getName().replaceFirst("[.][^.]+$|bad format", "") + "_edited.SRT");
            PrintWriter pw = new PrintWriter(outFile);

            pw.write(sb.toString());
            pw.flush();
            pw.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static List<String> getAllMatches(String text, String regex) {
        List matches = new ArrayList<>();
        Matcher m = Pattern.compile("(?=(" + regex + "))").matcher(text);
        while (m.find()) {
            matches.add(m.group(1));
        }
        return matches;
    }

}