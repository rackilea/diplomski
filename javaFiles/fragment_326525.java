RussianNestingDoll doll  = RussianNestingDoll.get(RussianNestingDoll.get(RussianNestingDoll.get()));

String content = doll.getInnerDoll()
                 .flatMap(d -> d.getInnerDoll())
                 .map(d -> d.get().toString())
                 .orElse("empty");
System.out.println(content);