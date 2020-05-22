fh.setFormatter(new Formatter() {
 public String format(LogRecord rec) {
    StringBuffer buf = new StringBuffer(1000);
    buf.append(new java.util.Date());
    buf.append(' ');
    buf.append(rec.getLevel());
    buf.append(' ');
    buf.append(formatMessage(rec));
    buf.append('\n');
    return buf.toString();
    }
  });