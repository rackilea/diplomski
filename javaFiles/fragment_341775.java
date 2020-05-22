public static final Pattern DIACRITICS_AND_MODIFIERS = Pattern.compile("[\\p{InCombiningDiacriticalMarks}\\p{IsLm}\\p{IsSk}]");

...

String text = Normalizer.normalize(input, Normalizer.Form.NFKD);
text = DIACRITICS_AND_MODIFIERS.matcher(text).replaceAll("").toLowerCase();