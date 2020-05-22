Field field = ClassA.getField("worker"));
  field.setAccessible(true);
  Field modifiers = Field.class.getDeclaredField("modifiers");
  modifiers .setAccessible(true);
  modifiers .setInt(field, field.getModifiers() & ~Modifier.FINAL);
  field.set(this, newWorker);