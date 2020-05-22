@Override
        protected void onListItemClick(ListView l, View v, int position, long id) {
            String item = (String) getListAdapter().getItem(position);
            Intent intent = new Intent(this, Lyrics.class);
                    intent.putExtra("song", item); //item is the listitem ie. song1, etc.
                    startActivity(intent);
        }