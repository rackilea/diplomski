public static <E extends Enum<E>> Set<E> parseValues(
        String string, Class<E> clazz
    ) { 
        EnumSet<E> set = EnumSet.noneOf(clazz);
        if (string == null) {
            return set; // ( better, NPE )
        }
        String[] elements = string.split(",");
        for (String element : elements) {
            element = element.trim();
            for (E type : EnumSet.allOf(clazz)) {
                if (type.name().equalsIgnoreCase(element)) {
                    set.add(type);
                    break;
                }
            }
            // ( Do we really want to ignore spurious values? )
        }
        return set;
    }