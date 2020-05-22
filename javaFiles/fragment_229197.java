Public class MyAdapter extends BaseAdapter {

    private ArrayList<MyItem> mItem;
    private int total;

    public MyAdapter(ArrayList<MyItem> items) {
        this.mItem = items;
        // on creation and after setting the items, sum their values up
        this.total = sumValuesUp();
    }

    ...

    public void addnewItem (MyItem item) {
        // add the value of the newly added item
        this.total += item.getValue();
        this.mItem.add(item);
        this.notifyDataSetChanged();
    }

    public void deleteAt(int position) {
        // subtract the value on deletion
        this.total -= this.mItem.get(position).getValue();
        this.mItem.remove(position);
        this.notifyDataSetChanged();
    }

    private int sumValuesUp() {
        int sum = 0;
        for (MyItem myItem : mItem) {
            sum += mItem.getValue();
        }
        return sum;
    }

    public int getTotal() {
        return total;
    }

...

}