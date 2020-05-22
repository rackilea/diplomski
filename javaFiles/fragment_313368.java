Bean bean = new Bean();
StringProperty nameProperty() = new JavaBeanStringPropertyBuilder()
        .bean(bean)
        .name("name")
        .build();
nameProperty().addListener((obs, oldName, newName) -> System.out.println("name changed from "+oldName+" to "+newName));
bean.setName("James");
System.out.println(nameProperty().get());