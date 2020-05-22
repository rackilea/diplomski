public class YourClass extends Whatever implements DialogInterface.OnClickListener{
    private item;
    private Item[] items;
    private AlertDialog.Builder builder1;
    private AlertDialog.Builder builder2;

    @Override
    public Item selectItem(final Item[] items) {
        this.items = items;
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setTitle("Select an Item");
        builder1.setItems(toStringArray(items), new DialogInterface.OnClickListener(this));
        builder1.setCancelable(false);
        builder1.show();

        return item;
    }

    @Override
    protected void onClick(DialogInterface dialog, int choice){
        if(dialog.equals(builder1)
            item = items[choice];
        else if(dialog.equals(builder2))
            // do what you want for dialog 2
    }
}