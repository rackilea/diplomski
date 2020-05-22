@Override
public void onRangeChange(RangeChangeEvent event)
{
    Range range = cellTable.getVisibleRange();
    int start = range.getStart();
    int length = range.getLength();
    List<ForumMessage> toSet = new ArrayList<ForumMessage>(length);
    for (int i = start; i < start + length && i < AllMessages.size(); i++)
        toSet.add((ForumMessage) AllMessages.get(i));
    cellTable.setRowData(start, toSet);
}