String className = "index.Abaddon";
    Class<?> clazz = Class.forName(className);
    Field field = clazz.getDeclaredField("counterList");
    if (field.getType().isArray()) {
        final String[] arr = (String[]) field.get(clazz.newInstance());
        System.out.println(Arrays.toString(arr));
    }