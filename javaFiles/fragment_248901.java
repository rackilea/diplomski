enum Options {
    SELECTION_SORT("selection sort"),
    INSERTION_SORT("insertion sort"),
    EXIT("exit");
    String value;
    Options(String value) {
        this.value = value;
    }
    static Options forInput(String input) {
        // TODO handle null/empty
        for (Options option: values()) {
            // ignoring case in comparison here
            if (option.value.equalsIgnoreCase(input)) return option;
        }
        return null; // or throw IllegalArgumentException
    }
    // minimal print of all available values as expected input
    static void printAll() {
        for (Options o: values()) {
            System.out.println(o.value);
        }
    }
}