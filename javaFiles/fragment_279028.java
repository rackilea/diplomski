@Override
public void onColorChanged(int color) {
    mValue = color;
    if (shouldPersist()) {
        persistInt(color);
    } else {
        if (isPersistent())
            Log.w("myapp", "shouldPersist() returned false. Check if this preference has a key.");
    }
    // (update preview box, other stuff)
}