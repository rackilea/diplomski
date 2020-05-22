int i = mProjectMap.size();
for(Map.Entry<Integer, Counter> entry : mProjectMap.entrySet()) {
    if((entry.getKey() - 1) % 2 == 0 || mLayoutRow == null) {
        mLayoutRow = new LinearLayout(mMainContext);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        );
        mLayoutRow.setOrientation(LinearLayout.HORIZONTAL);
        mLayoutRow.setGravity(Gravity.CENTER);
        mLayoutRow.setLayoutParams(lp);
        mLayoutProjects.addView(mLayoutRow);
    }

    mLayoutRow.addView(entry.getValue());
}