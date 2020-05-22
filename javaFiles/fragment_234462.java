public void setSelectedPosition(int position) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setSelected(i == position);
        }
        notifyDataSetChanged();
    }