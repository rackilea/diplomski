public static void main(String[] args) {
    String[] inputs = { "180-200g/6-7oz flour", "3-5g sugar", "6g to 7g sugar", "2 1/2 tbsp flour", "3/4 cup flour" };
    String[] outputs = { "180 - 200 g / 6 - 7 oz flour", "3 - 5 g sugar", "6 g to 7 g sugar", "2 1/2 tbsp flour", "3/4 cup flour" };

    int i = 0;
    for (String input : inputs) {
        String output = input.replaceAll("(?=-)|(?<=-)|(?<=[^\\d ])(?=/)|(?<=\\d/?)(?=[^\\d /])|(?<=\\D/)(?=\\d)", " ");

        if (!output.equals(outputs[i++])) {
            System.out.println("Failed with input: " + input);
            System.out.println("Expected: " + outputs[i - 1]);
            System.out.println("  Actual: " + output);
        }
    }
}