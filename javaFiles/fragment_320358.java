} else if (value instanceof String[]) {
  out.append(Arrays.toString((String[]) value));
} else if (value instanceof CharSequence[]) {
  out.append(Arrays.toString((CharSequence[]) value));
} else if (value instanceof Parcelable[]) {
  out.append(Arrays.toString((Parcelable[]) value));