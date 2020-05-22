private void deliverResults(ActivityClientRecord r, List<ResultInfo> results) {
    final int N = results.size();
    for (int i=0; i<N; i++) {
        ResultInfo ri = results.get(i);
        try {
            if (ri.mData != null) {
                ri.mData.setExtrasClassLoader(r.activity.getClassLoader());
            }
            if (DEBUG_RESULTS) Slog.v(TAG,
                    "Delivering result to activity " + r + " : " + ri);
            r.activity.dispatchActivityResult(ri.mResultWho,
                    ri.mRequestCode, ri.mResultCode, ri.mData);
        } catch (Exception e) {
            if (!mInstrumentation.onException(r.activity, e)) {
                throw new RuntimeException(
                        "Failure delivering result " + ri + " to activity "
                        + r.intent.getComponent().toShortString()
                        + ": " + e.toString(), e);
            }
        }
    }
}