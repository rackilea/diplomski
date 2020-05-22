private static final Map<String, Class<?>> NAME_TO_CLASS = new Map<>();
static {
  NAME_TO_CLASS.put("c", c.class);
  ...
}

static void main(String[] args) {
  ...
  controller.start(NAME_TO_CLASS.get(args[0]), 1);
}