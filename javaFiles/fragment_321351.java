Field[] fields = DummyClass.class.getDeclaredFields();
for (Field f : fields) {
    if (Modifier.isStatic(f.getModifiers()) && isRightName(f.getName())) {
        doWhatever(f);
    } 
}