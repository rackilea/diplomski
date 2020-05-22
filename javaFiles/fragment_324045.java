public class HistoryItemDuplicateInfo
implements TObjectHashingStrategy<HistoryItem> {

  @Override
  public int computeHashCode(HistoryItem obj) {
     ...
  }

  @Override
  public boolean equals(HistoryItem arg0, HistoryItem arg1) {
    ...
  }
}