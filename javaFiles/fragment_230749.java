Class<?> cls = Enchantment.class;
try {
    Field f = cls.getField("PROTECTION_ENVIRONMENTAL");
    System.out.println(f.get(cls));
} catch (Exception e) {
    e.printStackTrace();
}