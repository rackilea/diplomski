for (String fullyQualifiedClassName: myIterable) {
    try {
        Class
            .forName(fullyQualifiedClassName)
            .getDeclaredField("importantVal").set(null, true);
    }
    // java 7 idiom here to simplify
    catch (ClassNotFoundException | NoSuchFieldException | 
           IllegalAccessException | IllegalArgumentException e) {
        // TODO handle
    }
}