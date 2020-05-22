public class Example {
    public static class Dictionary extends ArrayList<String> {

        public Dictionary() {

            this.add("abalone");
            this.add("abandon");
            this.add("abashed");
            this.add("abashes");
            this.add("abasing");
            this.add("abating");
            this.add("abdomen");
            this.add("abducts");
            this.add("abetted");
            this.add("abetter");
            this.add("abettor");
            this.add("abiding");
            this.add("ability");
            this.add("abjured");
            this.add("abjures");
            this.add("abolish");
            this.add("aborted");
            this.add("abounds");
            this.add("abraded");
            // and then more words

        }
    }

    public static void main(String[] args) {
        List<String> realWords = new ArrayList<String>(
                Arrays.asList("abalone", "foobar", "abolish"));
        Dictionary d = new Dictionary();
        realWords.retainAll(d);
        System.out.println(realWords);
    }

}