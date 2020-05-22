class A implements OnClickListener {

    onCreate() {
        myButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.myButtonId:
                // do something
                break;
            // more cases
            default: 
                Log.w(LOG_TAG, "not implemented");
        }
    }
}