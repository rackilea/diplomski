public void removeAt(int position) {
    recordingArrayList.remove(position);
    notifyItemRemoved(position);
    notifyItemRangeChanged(position, recordingArrayList.size());

    String uri = recordingArrayList.get(position).getUri();
    File file = new File (uri);
    file.delete();
}