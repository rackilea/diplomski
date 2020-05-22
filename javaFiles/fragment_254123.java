if (field.getType() == Integer.TYPE || field.getType() == Integer.class) {
    Integer i = masterValue.intValue() + childValue.intValue();
    setMethod.invoke(master, i);
} else if (field.getType() == Long.TYPE || field.getType() == Long.class) {
    Long l = masterValue.longValue() + childValue.longValue();
    setMethod.invoke(master, l);
} else if (field.getType() == Float.TYPE || field.getType() == Float.class) {
    Float f = masterValue.floatValue() + childValue.floatValue();
    setMethod.invoke(master, f);
} else if (field.getType() == Double.TYPE || field.getType() == Double.class) {
    Double d = masterValue.doubleValue() + childValue.doubleValue();
    setMethod.invoke(master, d);
}