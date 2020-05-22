static public void combos(String[] inputs, List<String> outputs, String preface, int maxDepth) {
        if (preface.length() >= maxDepth)
           return;
        for (String s : inputs) {
           // swap the order of these two lines if you want depth first
           outputs.add(preface+s);
           combos(inputs, outputs, preface+s, maxDepth);
        }       
     }


     public static void main(String[] args) {
        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        ArrayList<String> outputs = new ArrayList<String>();
        combos(numbers, outputs, "", 3);
        System.out.println(outputs);

     }