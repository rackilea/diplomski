public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    Pattern p = Pattern.compile("([-+]?[0-9]+(?:\\.[0-9]+)?)");

    String[] tens = {"Ten", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] teens = {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
        "Nineteen"};
    String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

    String phrase = null;
    while (scanner.hasNextLine()) {
        phrase = scanner.nextLine();
        // if input is an empty line, exit from loop
        if (phrase.isEmpty()) {
            break;
        }

        List<Integer> numbers = new ArrayList<>();
        Matcher m = p.matcher(phrase);
        while (m.find()) {
            numbers.add(Integer.parseInt(m.group()));
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) >= 20) {
                if (numbers.get(i) % 10 == 0) {
                    phrase = phrase.replaceAll(Integer.toString(numbers.get(i)),
                            tens[((numbers.get(i) - numbers.get(i) % 10) / 10) - 1]);
                } else {
                    phrase = phrase.replaceAll(Integer.toString(numbers.get(i)),
                            (tens[((numbers.get(i) - numbers.get(i) % 10) / 10) - 1] + "-"
                            + ones[numbers.get(i) % 10]));
                }
            } else if (numbers.get(i) < 20 && numbers.get(i) > 10) {
                phrase = phrase.replaceAll(Integer.toString(numbers.get(i)), teens[(numbers.get(i) % 10) - 1]);
            } else if (numbers.get(i) < 10 && numbers.get(i) > 0) {
                phrase = phrase.replaceAll(Integer.toString(numbers.get(i)), ones[numbers.get(i)]);
            } else if (numbers.get(i) == 10) {
                phrase = phrase.replaceAll(Integer.toString(numbers.get(i)), "Ten");
            } else if (numbers.get(i) == 0) {
                phrase = phrase.replaceAll(Integer.toString(numbers.get(i)), "Zero");
            }
        }
        System.out.println(phrase);
    }
}