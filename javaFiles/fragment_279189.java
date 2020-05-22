for (int i = 0; i < names.size(); i++) {
    String name = names.get(i);
    String price = prices.get(i);
    String url = urls.get(i);

    model.addRow(new Object[] { name, price, url });
}