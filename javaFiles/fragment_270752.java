if (selectedSongs.contains(sSongs[position])) {
  holder.linearlayout.setBackgroundColor(R.color.color_accent);
} else {
  //else as viewholders are reused
  holder.linearlayout.setBackgroundColor(R.color.default_color);
}