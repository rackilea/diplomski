try {
   Field field = entity.getClass().getField("street");
   if (field.getType().equals(String.class) {
      street = (String) field.get(entity);
   }
} catch (NoSuchFieldException ex) {
  /* ignore */
}