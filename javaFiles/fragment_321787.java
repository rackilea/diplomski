public static void main(String[] args) {
        Brochure b = new Brochure();
        Course c = new Course();
        c.id = "cs501";
        c.name = "Software Engineering";
        b.courses = new HashMap<String, Course>();
        b.courses.put(c.id, c);
        c = new Course() // You need to add this
        c.id = "cs519";
        c.name = "Network Security";
        b.courses.put(c.id, c);

        System.out.println(convertObjectToXml(Brochure.class, b));

}