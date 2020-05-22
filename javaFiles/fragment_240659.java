public class A {

    public static void test(final int x) throws InterruptedException {
        new Thread() {
            public void run() {
                System.out.println(x);
                for (Constructor<?> cons : this.getClass()
                        .getDeclaredConstructors()) {
                    StringBuilder str = new StringBuilder();
                    str.append("constructor : ").append(cons.getName())
                            .append("(");
                    for (Class<?> param : cons.getParameterTypes()) {
                        str.append(param.getSimpleName()).append(", ");
                    }
                    if (str.charAt(str.length() - 1) == ' ') {
                        str.replace(str.length() - 2, str.length(), ")");
                    } else
                        str.append(')');
                    System.out.println(str);
                }
            }

        }.start();
        Thread.sleep(2000);
        }

    public static void main(String[] args) throws InterruptedException {
        test(100);
    }

}