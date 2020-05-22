private void ShowIntro(String title, String text, int viewId, final int type) {

    new GuideView.Builder(this)
            .setTitle(title)
            .setContentText(text)
            .setTargetView((LinearLayout)findViewById(viewId))
            .setContentTextSize(12)//optional
            .setTitleTextSize(14)//optional
            .setDismissType(GuideView.DismissType.targetView) //optional - default dismissible by TargetView
            .setGuideListener(new GuideView.GuideListener() {
                    @Override
                    public void onDismiss(View view) {
                        if (type == 1) {
                            ShowIntro("Editor", "Edit any photo from selected photos than Apply on your video", R.id.button_tool_editor, 6);
                        } else if (type == 6) {
                            ShowIntro("Duration", "Set duration between photos", R.id.button_tool_duration, 2);
                        } else if (type == 2) {
                            ShowIntro("Filter", "Add filter to video ", R.id.button_tool_effect, 4);
                        } else if (type == 4) {
                            ShowIntro("Add Song", "Add your selected song on your video ", R.id.button_tool_music, 3);
                        } else if (type == 3) {
                            ShowIntro("Overlay", "Add your selected overlay effect on your video ", R.id.button_tool_overlay, 5);
                        } else if (type == 5) {
                            SharePrefUtils.putBoolean("showcase", false);
                        }
                    }
                })
            .build()
            .show();
}