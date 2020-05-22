String input = "1 2 fish1 3 4 fish2 5 6 fish3 7 8 fish1 9 10 fish2 11 12...";

try (@SuppressWarnings("resource") Scanner sc = new Scanner(input).useDelimiter("fish[123]")) {
    while (sc.hasNext()) {
        String inputPairs = sc.next().trim();
        System.out.println(inputPairs);
    }
}