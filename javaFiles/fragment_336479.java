public Fragment findFragmentById(int id) {
    if (mAdded != null) {
        // First look through added fragments.
        for (int i=mAdded.size()-1; i>=0; i--) {
            Fragment f = mAdded.get(i);
            if (f != null && f.mFragmentId == id) {
                return f;
            }
        }
    }
    if (mActive != null) {
        // Now for any known fragment.
        for (int i=mActive.size()-1; i>=0; i--) {
            Fragment f = mActive.get(i);
            if (f != null && f.mFragmentId == id) {
                return f;
            }
        }
    }
    return null;
}