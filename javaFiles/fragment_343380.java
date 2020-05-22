String str = "[a2, a3][a4, a6][a10, a22]";
for (String x : str.split("\\]\\[")) {
    for (String s : x.split("\\s*,\\s*")) {
        System.out.println(s.replaceAll("\\D", ""));
    }
}