int firstClickIndex = -1;

grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView <? > parent, View view, int position, long id) {
        if (-1 == firstClickIndex) {
            firstClickIndex = position;
        } else {
            final int fstDrawable = adapter.get(firstClickIndex);
            final int sndDrawable = adapter.get(position);

            if (fstDrawable == sndDrawable) {
                // Remove stuff, then reset firstClickIndex.
            } else {
                // Reset firstClickIndex.
            }

        }
    }
});