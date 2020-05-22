private static Comparator<ListItem> cmp = new Comparator<myOtherObject>() {
       public int compare(myOtherObjectitem1, myOtherObjectitem2) {
            return (Integer.valueOf(myOtherObject.getRating()).compareTo(Integer.valueOf(myOtherObject.getRating())));
        }
    };

    static Comparator<ListItem> getComparator() {
        return cmp;
    }