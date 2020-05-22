Part part1 = Part.newBuilder().setText("I want to cancel a card ended in  ").build();
        Part part2 = Part.newBuilder().setText("5123").setEntityType("@cardNumber").setAlias("cardNumber")
                .setUserDefined(true).build();
        List<Part> parts = new ArrayList<Part>();
        parts.add(part1);
        parts.add(part2);