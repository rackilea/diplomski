public static boolean check(String checkedAgainst, String items) {
    List<String> checkedAgainstList = new ArrayList<>(Arrays.asList(checkedAgainst.split("\\s*,\\s*")));
    List<String> list = Arrays.asList(items.split("\\s*,\\s*"));
    checkedAgainstList.retainAll(list);
    return checkedAgainstList.equals(list);
}