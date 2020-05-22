public static List<String> getList(Scanner in) {
    List<String> list = new ArrayList<String>();

    while (in.hasNextLine()) {
        String line = in.nextLine();
        if (line.equals(".")) {
            break;
        }
        else {
            list.add(line);
        }
    }
    return list;
}