resultString = '';
for (i = 0; i < length(s); i++) {
  if ("AEIOUaeiou".indexOf(s[i]) != 0) {
    resultString = '_' + resultString;
  } else {
    resultString = s[i] + resultString;
  }
}