@Test
public void atest() {
    String re = "(?<=[A-Za-z])-(?=\\d+)";
    String[] ss = new String[] { "-11", "v-11", "v-", "-2-11", "v-11-", "-v-11-" };
    for (String s : ss) {
        System.out.println(s + " => " + Arrays.toString(s.split(re)));
    }
}