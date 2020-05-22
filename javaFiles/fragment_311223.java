public class CustomSwipeAdapter01 extends PagerAdapter {

    public interface NewPermitListener {

        void onPermitClicked(boolean over);
    }

    private NewPermitListener mListener;
    ...

    public CustomSwipeAdapter01(Context ctx, NewPermitListener listener) {
        this.ctx = ctx;
        // pass the listener in the constructor
        mListener = listener;
    }

    ...

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        ...
        btn_back_story01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ...
                // call the method
                mListener.onPermitClicked(false);
            }
        });

        return item_view;
    }
}