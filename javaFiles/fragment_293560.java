String str = "Nimal read/write book/newspaper from his pen.";

ArrayList<String> wordArrayList = new ArrayList<String>();
String[] array = str.split("\\s+"); // split based on one or more space
for (int i = 0; i < array.length - 1; i++) {
    String s1 = array[i];
    String s2 = array[i + 1];

    String[] a1 = s1.split("/"); //split based on forward slash
    String[] b1 = s2.split("/"); //split based on forward slash
    for (String a : a1) {
        for (String b : b1) {
            String word = a + "/" + b;
            wordArrayList.add(word);
            System.out.println(word);
        }
    }
}