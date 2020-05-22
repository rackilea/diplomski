public void clearSelection() {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setSelected(false);
        }
        notifyDataSetChanged();
    }