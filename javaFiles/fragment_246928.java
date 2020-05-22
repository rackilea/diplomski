Pattern p = Pattern.compile("\\d+");
Matcher m = p.matcher("");
for (String s : myStringList) {
    if ( m.reset(s).matches() ) {
        doSomething();
    }
}