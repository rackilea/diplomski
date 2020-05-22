@Override
    public int compare(final ArrayList<Integer> entry1, final ArrayList<Integer> entry2){
        if (entry1 == null && entry2 == null)
            return 0;
        if (entry1 == null)
            return 1;
        if (entry2 == null)
            return -1;
        if (entry1.isEmpty() && entry2.isEmpty())
            return 0;
        if (entry1.isEmpty())
            return 1;
        if (entry2.isEmpty())
            return -1;
        return entry1.get(0).compareTo(entry2.get(0));
    }