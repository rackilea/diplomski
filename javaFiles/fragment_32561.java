private static String getCustom(RequestDto requestDto) throws NoSuchFieldException, IllegalAccessException {
    return Arrays.stream(requestDto.getClass().getDeclaredFields())
            .filter(e -> e.getName().startsWith("custom"))
            .findFirst() // if the first match suffices
            .map(f -> {  // you may want to extract that part if you use streams
                f.setAccessible(true);
                try {
                    return (String) f.get(requestDto);
                } catch (IllegalAccessException e) {
                    // TODO whatever you need to do...
                    return null;
                }
            }).orElseThrow(IllegalArgumentException::new); // or whatever suites better
}