public class Test {
        public static void main(String... args) { 

            ClassLoader cl = Test.class.getClassLoader();
            String f = cl.getResource("").getFile();

            File cwd = new File(f);

            if (cwd.toString().endsWith("!"))
                cwd = cwd.getParentFile();

            JOptionPane.showMessageDialog(null, cwd);
        }
    }