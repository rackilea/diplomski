TypedValue typedValue = new TypedValue();

    // I used getActivity() as if you were calling from a fragment.
    // You just want to call getTheme() on the current activity, however you can get it
    getActivity().getTheme().resolveAttribute(android.R.attr.selectableItemBackground, typedValue, true);

    // it's probably a good idea to check if the color wasn't specified as a resource
    if (typedValue.resourceId != 0) {
        mView.setBackgroundResource(typedValue.resourceId);
    } else {
        // this should work whether there was a resource id or not
        mView.setBackgroundColor(typedValue.data);
    }