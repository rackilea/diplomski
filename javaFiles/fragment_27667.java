if ("\\t".equals(sTerminatedBy)) {
  separator = '\t';
} else if (null == sTerminatedBy || "".equals(sTerminatedBy)) {
  separator = ' ';
} else {
  separator = sTerminatedBy.charAt(0);
}