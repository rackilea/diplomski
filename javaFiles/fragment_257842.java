public class ReadContents {

    public static void main(String[] args) {
        ArrayList<File> files = new ArrayList();

        ArrayList<String> tasks = new ArrayList();
        ArrayList<String> hrs = new ArrayList();
        ArrayList<String> others = new ArrayList();
        String[] raw;
        files.add(new File("File path"));
        try (BufferedReader br = new BufferedReader(new FileReader(files.get(0)))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("/*") | line.equals("")) {
                    continue;
                } else {
                    raw = line.split("\\s+");
                    if (raw.length < 3) {
                        tasks.add(raw[0]);
                        hrs.add(raw[1]);
                        others.add("");
                    }else{
                        tasks.add(raw[0]);
                        hrs.add(raw[1]);
                        others.add(raw[2]);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}