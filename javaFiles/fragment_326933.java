BiFunction<String,List<String>,YourJavaItem> createObject =
    (line, sfc) -> {
        if ("abc".equals(sfc.get(2))) {
            System.out.println("abc found!");
        }
        return new YourJavaItem(line);
    }
}