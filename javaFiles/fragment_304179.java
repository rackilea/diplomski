context.put("name", "Velocity@mycompany.com");

    String name = "myname@yahoo.com";
    context.put("userName", name);

    Template template = null;

    template = Velocity.getTemplate("test.vm");

    StringWriter sw = new StringWriter();

    try {
        template.merge(context, sw);
    } finally {
        sw.close();
    }
    System.out.println(sw);