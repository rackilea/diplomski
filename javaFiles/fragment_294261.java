class Main {
    public static class A {
        private String whatever;
        private B b = new B();

        private static class B {
            final ArrayList<String> c = new ArrayList<String>();

            private void addItem(String z) {
                this.c.add(z);
            }

            private String getItem(int nr) {
                return this.c.get(nr);
            }
        }
    }

    public static class Reflect extends A {
        public static void main(String... ignored) throws Exception {
            Reflect ref = new Reflect();
            Class getA = ref.getClass().getSuperclass();
            Field getB = getA.getDeclaredField("b");
            getB.setAccessible(true);
            Object b = getB.get(ref);

            Method addItem = b.getClass().getDeclaredMethod("addItem", String.class);
            addItem.setAccessible(true);
            addItem.invoke(b, "Hello");

            Method getItem = b.getClass().getDeclaredMethod("getItem", int.class);
            getItem.setAccessible(true);
            String hi = (String) getItem.invoke(b, 0);
            System.out.println(hi);
        }
    }
}