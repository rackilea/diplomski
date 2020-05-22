Class<?> enumClass = Class.forName(className);
if (enumClass.isEnum()) {
    @SuppressWarnings("unchecked") // we just checked it, so it had better work
    Enum<?> value1 = Enum.valueOf((Class<? extends Enum>) enumClass, enumValue);
    EnumeratedThing<?> thing1 = new EnumeratedThing(value1);
}