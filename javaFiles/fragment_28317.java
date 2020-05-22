[...]
        if (!firstVal) {
            w.write(",");
        }
        w.write("\"");

        // EDIT HERE
        if (val == null) {
            System.out.println("This val is null: " + values);
        }
        // .....

        for (int i = 0; i < val.length(); i++) {
        [...]