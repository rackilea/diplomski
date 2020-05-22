public class MySettingHolder extends RecyclerView.ViewHolder {

        public int type;
        public ImageView settingImage;
        public TextView settingTitle, settingSubtitle;

        public MySettingHolder(View view) {
            super(view);
            settingImage = (ImageView) view.findViewById(R.id.settingImage);
            settingTitle = (TextView) view.findViewById(R.id.settingTitle);
            settingSubtitle = (TextView) view.findViewById(R.id.settingSubtitle);
        }
    }