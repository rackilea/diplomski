public void addNotHiredRoomsToLayout() {

for (String name : Constants.existingRoomNames) {
    textView2 = new TextView(this);
    boolean contains = false;
    for (Room room : mCalendarModel.mList.getRoomList()) {
        if (room.getName().equals(name)) {
            contains = true;
        }
    }
    if (!contains) {
        textView2.setText(name + ": Free");
        linearLayout.addView(textView2);
    }
}
}