Class<? extends Enchantment> cls = Enchantment.class;
try {
    Field f = cls.getField("PROTECTION_ENVIRONMENTAL");
    Object obj = f.get(cls);
    if (cls.isAssignableFrom(obj.getClass())) {
        Enchantment e = cls.cast(obj);
        System.out.println(e);
    }
} catch (Exception e) {
    e.printStackTrace();
}