Collections.sort(ratingSort, new Comparator<GifModel>() {

    @Override
    public int compare(GifModel lhs, GifModel rhs) {
        if (lhs.getRating() < rhs.getRating())
            return -1;
        else if (lhs.getRating() > rhs.getRating())
            return 1;
        return 0;
    }

});