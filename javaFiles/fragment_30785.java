public void onClick(View v) {
    int id = v.getId();
    int currentIndex = listView.indexOfChild(v.getParent());
    View view = listView.getChildAt(currentIndex);
    switch(id) {
    case upButtonId:
        listView.removeView(view);
        listView.addView(view, currentIndex--);
        if(currentIndex == 0)
            //disable Up Button
        break;
    case downButtonId:
        listView.removeView(view);
        listView.addView(view, currentIndex++);
        if(currentIndex == listView.getChildCount() - 1)
            //disable Down Button
        break;
    }
}