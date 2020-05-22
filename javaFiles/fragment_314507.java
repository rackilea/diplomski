class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String replaceTags(String rawText) {
        Matcher m = Pattern.compile("%(.+?)%").matcher(rawText);
        boolean result = m.find();
        if (result) {
            StringBuffer sb = new StringBuffer();
            do {
                m.appendReplacement(sb, Matcher.quoteReplacement(getField(m.group(1))));
                result = m.find();
            } while (result);
            m.appendTail(sb);
            return sb.toString();
        }
        return rawText.toString();
    }

    private String getField(String name) {
        try {
            return String.valueOf(this.getClass().getDeclaredField(name).get(this));
        } catch (Exception e) {
            throw new IllegalArgumentException("could not read value for field: " + name);
        }
    }
}