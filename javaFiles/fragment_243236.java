public static final int SEARCH_TITLE = 12;
public static final int SEARCH_ARTIST = 23;
public static final int SEARCH_KARAOKENUMBER = 34;

    @Override
public View getView(int position, View convertView, ViewGroup parent) {

    songListWidgetHolder viewHolder = null;
    String title;
    String artist;

    if (convertView == null) {
        //
        if (musicList != null && musicList.size() > 0) {

            // Log.d("size", String.valueOf(musicList.size()));

            LayoutInflater mInflater = (LayoutInflater) Act
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            //
            convertView = mInflater.inflate(R.layout.list_row, null);

            final String _title = musicList.get(position).getTitle();

            title = AppUtils.ShortText(_title, 7);

            final String _artist = musicList.get(position).getArtist();

            artist = AppUtils.ShortText(_artist, 5);

            switch (sortkey) {
            case SORT_ARTIST_DESC:
            case SORT_ARTIST_ASC:

                viewHolder = new songListWidgetHolder();
                //
                viewHolder.ArtistTV = (TextView) convertView
                        .findViewById(R.id.artisttx);
                viewHolder.ArtistTV = (TextView) convertView
                        .findViewById(R.id.artisttv);
                viewHolder.TitleTV = (TextView) convertView
                        .findViewById(R.id.titletv);
                viewHolder.MusicIcon = (ImageView) convertView
                        .findViewById(R.id.musicImage);
                //
                viewHolder.TitleTV.setText(artist);
                viewHolder.ArtistTV.setText(title);
                viewHolder.MusicIcon.setImageResource(R.drawable.music);
                //
                convertView.setTag(viewHolder);

                return convertView;

            default:
                break;
            }

            viewHolder = new songListWidgetHolder();
            viewHolder.ArtistTV = (TextView) convertView
                    .findViewById(R.id.artisttv);
            viewHolder.TitleTV = (TextView) convertView.findViewById(R.id.titletv);
            viewHolder.MusicIcon = (ImageView) convertView
                    .findViewById(R.id.musicImage);
            viewHolder.NewMusicTV = (TextView) convertView
                    .findViewById(R.id.newmusicTV);
            convertView.setTag(viewHolder);
        }
    } else {
        viewHolder = (songListWidgetHolder) convertView.getTag();
    }

    if (musicList.size() > 0 && musicList != null){
    final String _title = musicList.get(position).getTitle();
    title = AppUtils.ShortText(_title, 7);
    final String _artist = musicList.get(position).getArtist();
    artist = AppUtils.ShortText(_artist, 5);
    viewHolder.TitleTV.setText(title);
    viewHolder.ArtistTV.setText(artist);
    viewHolder.MusicIcon.setImageResource(R.drawable.music);
    Date musicModifiedDate = musicList.get(position)
            .getDatemodified();
    Date systemDate = new Date(System.currentTimeMillis());

    if (musicModifiedDate != null)
        if (AppUtils.GetDateDifference(systemDate, musicModifiedDate)) {
            viewHolder.NewMusicTV.setText("New");
        }

    AnimationManager.StartAnimation(Act, AnimationManager.PUSH_UP_IN_ANIMATION, convertView,1000);
    }
    return convertView;
}
// --------------------------------------------------------------------------------

// We used it to Search songs in our musicList arraylist
    public Filter getFilter(final int keySearch) {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                final FilterResults oReturn = new FilterResults();
                // final CarouselDataItem[] musicList;
                final ArrayList<music> results = new ArrayList<music>();
                //
                if (_musicList == null)
                    _musicList = musicList;
                // check if constraint is not null
                if (constraint != null) {
                    // check if the music List have data
                    if (_musicList != null && _musicList.size() > 0) {
                        // loop to the arraylist of music list
                        for (final music _music : _musicList) {
                            // check if the music object is equals to the
                            // constraint character
                            switch (keySearch) {
                            case SEARCH_TITLE:
                                if (searchTitle(_music, constraint.toString()))
                                    results.add(_music);
                                break;
                            case SEARCH_ARTIST:
                                if (searchArtist(_music, constraint.toString()))
                                    results.add(_music);
                                break;
                            case SEARCH_KARAOKENUMBER:
                                if (searchKaraokeNumber(_music,
                                        constraint.toString()))
                                    results.add(_music);
                                break;
                            default:
                                break;
                            }
                            //
                        }
                    }
                    // set results of the filter search in oReturn
                    oReturn.values = results;
                }
                // return the results
                return oReturn;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint,
                    FilterResults results) {
                musicList = (ArrayList<music>) results.values;
                notifyDataSetChanged();
            }
        };
    }

private boolean searchTitle(music song, String title) {
    String _title = song.getTitle().toLowerCase();
    return _title.startsWith(title.toLowerCase());
}

private boolean searchArtist(music song, String artist) {
    String _artist = song.getArtist().toLowerCase();
    return _artist.startsWith(artist.toLowerCase());
}

private boolean searchKaraokeNumber(music song, String karaokenum) {
    String _karaokenum = song.getMusicrefID();
    return _karaokenum.contains(karaokenum);
}