holder.checkBox.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Log.d(TAG, arg0.toString());
                Log.v(TAG, "FROM " + mprojects.isCheck() + " TO " + !mprojects.isCheck() );
                mprojects.setCheck(!mprojects.isCheck());
                Log.d(TAG, "Project " + mprojects.getId());
                saveSpinnerData(inflater.getContext() , mprojects);
            }


        });