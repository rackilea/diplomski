Bundle saveFragmentBasicState(Fragment f) {
    Bundle result = null;

    if (mStateBundle == null) {
        mStateBundle = new Bundle();
    }
    f.onSaveInstanceState(mStateBundle);
    if (!mStateBundle.isEmpty()) {
        result = mStateBundle;
        mStateBundle = null;
    }

    if (f.mView != null) {
        saveFragmentViewState(f);
    }
    if (f.mSavedViewState != null) {
        if (result == null) {
            result = new Bundle();
        }
        result.putSparseParcelableArray(
                FragmentManagerImpl.VIEW_STATE_TAG, f.mSavedViewState);
    }
    if (!f.mUserVisibleHint) {
        // Only add this if it's not the default value
        // @@@ BUG, result may not have been created, can be null!
        if (result == null) {
            result = new Bundle();
        }
        result.putBoolean(FragmentManagerImpl.USER_VISIBLE_HINT_TAG, f.mUserVisibleHint);
    }

    return result;
}