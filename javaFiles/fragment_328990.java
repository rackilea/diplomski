public class DrawerItemClickListener implements ListView.OnItemClickListener {

    private Activity mActivity;
    public DrawerItemClickListener(Activity activity){
        mActivity = activity;
    }

        /** Swaps fragments in the main content view */
    private void selectItem(int position) {

        switch(position)
        {
            case 0:
            Intent intent = new Intent(mActivity, OfflineAccess.class);
            mActivity.startActivity(intent);
            break;
        /.../

    }
}