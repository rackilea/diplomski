btnRetirer.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if ( item.getCount() > 0)
            item.setCount( item.getCount() - 1 );
        else
            ItemAdapter.super.remove(item);
        notifyDataSetChanged();
    }
});