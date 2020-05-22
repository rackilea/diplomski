for (Field f : fields) {

        if (f.getType() == java.lang.String.class) {

            try {
                f.setAccessible(true); // make field accessible.
                String value = (String) f.get(this);
                // ...