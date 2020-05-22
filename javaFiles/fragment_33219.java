public void clearTag() {
    List<Tag> tags = binding.search.tagView.getTags();
    List<Tag> tagsToRemove = new ArrayList<>();
    Log.d(TAG, "clearTags: " + tags);
    for (Tag tag : tags) {
        Log.d(TAG, "clearTag: " + tag + " " + tag.getLayoutColor());
        if (tag.getLayoutColor() == R.color.red) {
           tagsToRemove.add(tag);
        } else if (tag.getLayoutColor() == R.color.blue) {
            tagsToRemove.add(tag);
        } else if (tag.getLayoutColor() == R.color.green) {
            tagsToRemove.add(tag);
        }
    }
    tags.removeAll(tagsToRemove);
    updateTagVisibility();
    //resetFilter();
}