public void updateData(List<String> filesList, int flag) {
    if (flag == 0) { //append
        for (int i = 0; i < filesList.size(); i++) {
            files.add(messageList.get(i));
            notifyItemInserted(getItemCount());
        }
    } else { //clear all
        files.clear();
        notifyDataSetChanged();
    }
}