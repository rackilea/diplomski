mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRecyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                menuCardIndex = position;
                PopupMenu popupMenu = new PopupMenu(Show.this, view);
                popupMenu.setOnMenuItemClickListener(Show.this);
                popupMenu.inflate(R.menu.menu_popup);
                popupMenu.show();
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));

@Override
public boolean onMenuItemClick(MenuItem item) {
    switch (item.getItemId()) {
        case R.id.one:
            Your_First_Operation;
            return true;
        case R.id.two:
            Your_Second_Operation;
            return true
        case R.id.three:
            Your_Third_Operation;
            return true
    }
    return false;
}