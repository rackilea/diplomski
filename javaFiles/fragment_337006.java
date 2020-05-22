public static String concatenate(Object object) {
    return Arrays.stream(object.getClass().getDeclaredFields())
                 .filter(f -> f.getType() == String.class)
                 .sorted(Comparator.comparing(Field::getName))
                 .map(f -> {
                      try { return (String)f.get(object); }
                      catch (IllegalAccessException e) { return null; }
                  })
                 .filter(Objects::nonNull)
                 .collect(Collectors.joining());
}