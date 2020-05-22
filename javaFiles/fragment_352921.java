public class FooTestApplication {

    public static void main(String[] args) {
        Project p = new Project();
        p.setLabel("Solar");
        p.setValue("foo");
        Project p2 = new Project();
        p2.setLabel("Gov");
        p2.setValue("foo2");
        Project p3 = new Project();
        p3.setLabel("foo");
        p3.setValue("foo3");
        Set<Project> projects = new TreeSet<>((o1, o2) -> {
            if (o1.getLabel().equals("foo")) return -2;
            if (o1.getLabel().equals("Solar")) return -1;
            if (o1.getLabel().equals("Gov")) return 1;
            return 0;
        });
        projects.add(p);
        projects.add(p2);
        projects.add(p3);

        projects.iterator().forEachRemaining(pp -> {
            System.out.println(pp.getLabel());
        });
    }
}