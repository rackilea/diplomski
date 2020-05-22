motels.clear();
for(DataSnapshot snapshot : snap.getChildren()) {
    Motel motel =  snap.getValue(Motel.class);
    motels.add(motel);
}
adapter.notifyDataSetChanged();