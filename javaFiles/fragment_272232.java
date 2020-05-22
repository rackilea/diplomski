private class CrimeHolder extends RecyclerView.ViewHolder{
        private TextView mTitleTextView;
        private TextView mDateTextView;

        CrimeHolder(View view){
            super(view);
            mTitleTextView = view.findViewById(R.id.textView);
            mDateTextView = view.findViewById(R.id.textView2);
        }
    }