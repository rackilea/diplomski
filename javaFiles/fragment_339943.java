m = Pattern.compile(pattern).matcher(input);
if (m.matches()) {
    int i = 0;
    for (String var : vars.keySet()) {
        vars.put(var, m.group(++i));
    }
}