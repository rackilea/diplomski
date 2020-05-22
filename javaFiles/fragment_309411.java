if (values[i] == null) {
  initialValues.putNull(names[i]);
} else if (values[i] instanceof Boolean) {
  initialValues.put(names[i], (Boolean)values[i]);
} else if (values[i] instanceof Byte) {
  initialValues.put(names[i], (Byte)values[i]);
} else if (values[i] instanceof Double) {
  initialValues.put(names[i], (Double)values[i]);
} else if (values[i] instanceof Float) {
  initialValues.put(names[i], (Float)values[i]);
} else if (values[i] instanceof Integer) {
  initialValues.put(names[i], (Integer)values[i]);
} else if (values[i] instanceof Long) {
  initialValues.put(names[i], (Long)values[i]);
} else if (values[i] instanceof Short) {
  initialValues.put(names[i], (Short)values[i]);
} else if (values[i] instanceof String) {
  initialValues.put(names[i], (String)values[i]);
} else if (values[i] instanceof byte[]) {
  initialValues.put(names[i], (byte[])values[i]);
} else if (values[i] instanceof ContentValues) {
  initialValues.putAll(names[i], (ContentValues)values[i]);
} else {
  throw new IllegalArgumentException(
      "can't put " + values[i].getClass().getName() + " in ContentValues.");
}