public List<Product6> mItems = new ArrayList()

public void setData(List<Product6> items) {
    this.mItems = items;
    notifyDataSetChanged()
}

private int grandTotal() {
    int totalPrice = 0;
    for (int i = 0; i < mItems.size(); i++) {
        totalPrice += mItems.get(i).getBack();
    }
    return totalPrice;
}

/* onCreateViewHolder and onBindViewHolder remains same */