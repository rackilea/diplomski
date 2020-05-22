public class CodeListing {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("classes.txt"));

        String line = br.readLine();
        Vector<String> classes = new Vector<>();
        while (line != null) {

            line = line.substring(2);
            if (!line.contains("$"))
                classes.add(line.replaceAll("/", ".").replaceAll(".class", ""));

            line = br.readLine();
        }
        Collections.sort(classes);
        for (String c : classes) {


            System.out.println("    "+c);
            try {
                for (Method m : Class.forName(c).getMethods()) {

                    boolean first = true;
                    System.out.print("        "+c+"."+m.getName()+"(");
                    for (Class<?> t : m.getParameterTypes()) {
                        if (!first)
                            System.out.print(", ");
                        else
                            first = false;
                        System.out.print(t.getSimpleName());
                    }
                    System.out.println(") : "+m.getReturnType().getSimpleName());

                }
                System.out.println();
            }
            catch (Error e) {}
            catch (Exception e) {}
        }
        br.close();
    }   
}