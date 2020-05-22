@Override
    public void onClick(DialogInterface dialog, int listIndex) {
        database.add(listIndex,object);
        database.remove(listIndex,object);
        ((MainActivity) getActivity()).dataUpdated();
    }