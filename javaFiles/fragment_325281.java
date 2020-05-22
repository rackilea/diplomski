Number raw;

 private void setRaw(final RawField raw, String fmt) {
    if(isDate(fmt)) {
      long t = ...
      this.raw = t;
    } else {
      if(isDouble(fmt)) {
        double x = .... 
        this.raw = x;
      }
    }
  }

  double y = field.raw.doubleValue();
  long n = field.raw.longValue();
  if (field.raw instanceof Double) { ... }