@Override
    public void onClick(View v) {
        DataFish newCurrent=data.get(getAdapterPosition());
        Toast.makeText(context, "You clicked an item", Toast.LENGTH_SHORT).show();
        final String ItemId = newCurrent.id;
        Intent intent = new Intent(context, ShowSingleRecordActivity.class);
        intent.putExtra("ID", ItemId);
        context.startActivity(intent);



    }