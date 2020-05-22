@Override
protected FilterResults performFiltering(CharSequence constraint) {
    FilterResults results = new FilterResults();

    final List<SongModel> l = dc.songList;
    int count = l.size();
    List<SongModel> nSongList = new ArrayList<SongModel>(count);
    String s = constraint.toString();
    s = s.replace((char)601,(char)1241);
    // or s.replace('\u0259','\u04D9');
    for (SongModel p : l) {
        if (p.getName().contains(s)) {
            nSongList.add(p);
        }
    }

    results.values = nSongList;
    results.count = nSongList.size();

    return results;
}