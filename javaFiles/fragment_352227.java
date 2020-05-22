public static String fieldFlags(Field fld, FieldInfo info) {
    ...
    Number numeric = null;
    if (fld == null) {
      ...
    } else {
      ...
      numeric = fld.numericValue();
    }
    ...
    if (numeric != null) {
      flags.append("#");
      // try faking it
      if (numeric instanceof Integer) {
        flags.append("i32");
      } else if (numeric instanceof Long) {
        flags.append("i64");
      } else if (numeric instanceof Float) {
        flags.append("f32");
      } else if (numeric instanceof Double) {
        flags.append("f64");
      } else if (numeric instanceof Short) {
        flags.append("i16");
      } else if (numeric instanceof Byte) {
        flags.append("i08");
      } else if (numeric instanceof BigDecimal) {
        flags.append("b^d");
      } else if (numeric instanceof BigInteger) {
        flags.append("b^i");
      } else {
        flags.append("???");
      }
      ...
    }