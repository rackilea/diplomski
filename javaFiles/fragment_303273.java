case DragEvent.ACTION_DROP:
    //Gridview position to swap with.
    int i =gv.pointToPosition((int)event.getX(), (int)event.getY());
    int j = Integer.parseInt(event.getClipData().getItemAt(0).getText().toString());
    Collections.swap(mUriList, i, j);
    Log.i(TAG, "Swapped " + i+ " with " + j);
    break;