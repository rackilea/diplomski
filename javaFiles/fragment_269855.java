final List<TripEventItem> items = new ArrayList<>();
for(int i = 0; i < results.size(); i++) {       
    final TripEventItem item = new TripEventItem(results.get(i), tripNumber);
    items.add(item);
}

for(int i = 0; i < items.size(); i++) {
    final TripEventItem item = items.get(i);
    item.addDomHandler(new ClickHandler() {
        @Override
        public void onClick(ClickEvent event) {
            for(int i = 0; i < items.size(); i++) {
                TripEventItem otherItem = items.get(i);
                restore(otherItem);
            }

            item.getElement().getStyle().setColor("blue");
        }
    }, ClickEvent.getType());
}