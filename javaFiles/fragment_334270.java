List<Boolean> wasclicked = new ArrayList<Boolean>();
for (int i = 0; i < NUM_CLICKS * 0.03; i++) {
    wasclicked.add(true);
}
for (int i = 0; i < NUM_CLICKS * 0.97; i++) {
    wasclicked.add(false)
}
Collections.shuffle(wasclicked);