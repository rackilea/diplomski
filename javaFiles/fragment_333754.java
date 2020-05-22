ClassName beef = ClassName.get(tacosPackage, "Beef");
ClassName chicken = ClassName.get(tacosPackage, "Chicken");
ClassName option = ClassName.get(tacosPackage, "Option");
ClassName mealDeal = ClassName.get(tacosPackage, "MealDeal");
TypeSpec menu = TypeSpec.classBuilder("Menu")
    .addAnnotation(AnnotationSpec.builder(mealDeal)
        .addMember("price", "$L", 500)
        .addMember("options", "$L", AnnotationSpec.builder(option)
            .addMember("name", "$S", "taco")
            .addMember("meat", "$T.class", beef)
            .build())
        .addMember("options", "$L", AnnotationSpec.builder(option)
            .addMember("name", "$S", "quesadilla")
            .addMember("meat", "$T.class", chicken)
            .build())
        .build())
    .build();
assertThat(toString(menu)).isEqualTo(""
    + "package com.squareup.tacos;\n"
    + "\n"
    + "@MealDeal(\n"
    + "    price = 500,\n"
    + "    options = {\n"
    + "        @Option(name = \"taco\", meat = Beef.class),\n"
    + "        @Option(name = \"quesadilla\", meat = Chicken.class)\n"
    + "    }\n"
    + ")\n"
    + "class Menu {\n"
    + "}\n");