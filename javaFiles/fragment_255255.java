TypedValue typedValue = new TypedValue();

getApplicationContext().getTheme().resolveAttribute(android.R.attr.colorPrimary, typedValue, true);

// it's probably a good idea to check if the color wasn't specified as a resource
if (typedValue.resourceId != 0) {
    layoutTitle.setBackgroundResource(typedValue.resourceId);
} else {
    // this should work whether there was a resource id or not
    layoutTitle.setBackgroundColor(typedValue.data);
}