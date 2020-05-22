char[] cs = str.toCharArray();
Arrays.sort(cs);
int n = numOccurrencesRequired - 1;
for (int i = n; i < cs.length; ++i) {
  boolean allSame = true;
  for (int j = 1; j <= n && allSame; ++j) {
    allSame = cs[i] == cs[i - j];
  }
  if (allSame) return true;
}
return false;