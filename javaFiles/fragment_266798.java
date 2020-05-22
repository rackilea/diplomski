public class Combination {

    //Use Set/HashSet instead of ArrayList if you do not want duplicate string
    //Set<String> combinations = new HashSet<String>();
    private ArrayList<String> combinations = new ArrayList<>();

    public void generate(String instr) {
        generate(instr, new StringBuffer(), 0);
    }
    private void generate(String instr, StringBuffer outstr, int index) {
        for (int i = index; i < instr.length(); i++) {
            outstr.append(instr.charAt(i));

            // Here you may add your rules to avoid all combinations
            combinations.add(outstr.toString());

            generate(instr, outstr, i + 1);
            outstr.deleteCharAt(outstr.length() - 1);
        }
    }

    public ArrayList<String> getCombinations() {
        return combinations;
    }
}