public static String calculateByName(String name) {
        return myGenericMethod("John Doe", t -> {
            try {
                return returnFullName (t);
            } catch (Exception e) {
                return "fallback name";
            }
        });
    }