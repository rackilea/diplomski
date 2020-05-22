public final class NashornTest {

    // Class can even be inner class. Must be public however!
    public static class MyData {

        private int id;
        private String name;

        public MyData(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("MyData[%d, %s]", id, name);
        }

    }

    @Test
    public void test() throws ScriptException {
        final ScriptEngineManager sem = new ScriptEngineManager();
        final ScriptEngine se = sem.getEngineByName("javascript");

        Object obj = se.eval(
            "var MyJavaData = Java.type('test.el.NashornTest$MyData');" +
            "new MyJavaData(42, 'The usual number');");

        // prints MyData[42, The usual number]
        System.out.println(obj);
    }

}