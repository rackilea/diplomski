public class Codage {

    private BufferedReader in;
    private BufferedWriter out;

    private HashMap<String, String> replacingValuesByKeys = new HashMap<String, String>();

    public Codage() {
        initialize();
    }

    private void initialize() {
        // I assumed that you have rule that a key like "proper" always goes to "100"
        // Initialize the map between keys and replacing values: 
        replacingValuesByKeys.put("usual", "1000");
        replacingValuesByKeys.put("proper", "100");
        replacingValuesByKeys.put("complete", "110");
        replacingValuesByKeys.put("convenient", "110");
        replacingValuesByKeys.put("nonprob", "111");
        replacingValuesByKeys.put("recommended", "001");
        replacingValuesByKeys.put("recommend", "1000");
    }

    public void doRelpacementInFile(){
        try {
            in = new BufferedReader(new FileReader("c:/nursery.txt"));
            out = new BufferedWriter(new FileWriter("c:/nursery.tmp"));

            String str = in.readLine();
            while (null != str) {
                Iterator<String> it = replacingValuesByKeys.keySet().iterator();
                while(it.hasNext())
                {
                    String toBeReplaced = it.next();
                    String replacementValue = replacingValuesByKeys.get(toBeReplaced);
                    // \\b is for word boundary, because you have both recommend and recommended
                    //        and we do not want to replacing the [recommend] part of recommended.
                    str = str.replaceAll("\\b"+toBeReplaced+"\\b", replacementValue);
                }
                // Write the fully replaced line to the temp file:
                out.append(str);
                out.newLine();

                // Do not forget to read the next line:
                str = in.readLine();
            }

        } catch (IOException e) {
            System.out.println("There was a problem:" + e);
        } finally{
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        File f = new File("c:/nursery.txt");
        f.delete();

        File f2 = new File("c:/nursery.tmp");
        f2.renameTo(new File("c:/nursery.txt"));
    }


    public static void main(String[] args) {
        Codage c = new Codage();
        c.doRelpacementInFile();
    }

}