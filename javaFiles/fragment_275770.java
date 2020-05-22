@Override
    public ChordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.user_chord_list_item;
        int layoutIdForFooterItem = R.layout.user_chord_add_new; //SOLUTION
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View listItem;
        ChordViewHolder viewHolder;

        if (viewType == R.layout.user_chord_list_item) {    //inflate normal list item
            listItem = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
            viewHolder = new ChordViewHolder(listItem);
            viewHolder.viewHolderIndex.setText("Chord " + viewHolderCount);
        }
        else{   //inflate "+ Add new" button for last list item
            listItem = inflater.inflate(layoutIdForFooterItem, parent, shouldAttachToParentImmediately);
            viewHolder = new ChordViewHolder(listItem);
        }

        viewHolderCount++;
        return viewHolder;
    }