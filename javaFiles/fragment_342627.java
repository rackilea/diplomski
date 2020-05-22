class Example1 {
    private String gender;
    private String pronoun;

    public void example1(String input_str) {
        if (input_str.toLowerCase().startsWith("b")) {
            pronoun = "he";
            gender = "boy"; // male?
        } else if (input_str.toLowerCase().startsWith("g")) {
            pronoun = "she";
            gender = "girl"; // female?
        }
    }
    public String getGender() {
        return gender;
    }
    public String getPronoun() {
        return pronoun;
    }
}