star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Your code here
                if(mListener != null) { //Just for safety check
                    mListener.onStarItemClicked(position);// this will send the callback to your Fragment implementation
                }
            }
        });