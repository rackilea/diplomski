public void addPurchases(double ... pur) {
  int purchasesLength = purchases.length;
  int combinedLength = pur.length + purchasesLength;
  purchases = Arrays.copyOf(purchases, combinedLength);
  for (int i = purchasesLength, j = 0; i < combinedLength; i++, j++) {
     purchases[i] = pur[j];
  }
}