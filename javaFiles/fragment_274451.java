public void onClick(View view) {
    switch(view.getId()){

        case R.id.stamp :
            mStamp.setImageResource(R.drawable.yourimagename);
            horizontalScrollView.setVisibility(View.VISIBLE);
            break;

    }
}