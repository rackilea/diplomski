private final List<ContentItem> items;
private final OnItemClickListener listener;

public ContentAdapter(List<ContentItem> items, OnItemClickListener listener) {
    this.items = items;
    this.listener = listener;
}