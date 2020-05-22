String str = "(no hi virtual x oy)\n\n house cat \n open it \n\n trying to....";

List<String> al = new ArrayList<String>(Arrays.asList(str.toString()
            .split("\\n")));

al.removeAll(Arrays.asList("", null)); // remove empty or null string

for (int i = 0; i< al.size(); i++) {
    System.out.println("Line " + i + " : " + al.get(i).trim());
}