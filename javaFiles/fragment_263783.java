Set<String> correctOptions = new HashSet<>(Arrays.asList("opt1", "opt2"));// and so on
String option = null;
do {
    System.out.print("select option: ");
    option = scanner.nextLine();
} while (!correctOptions.contains(option));
//here you are sure that selected option is correct
//handle it as you want.