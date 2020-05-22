dialog.setPositiveButton(mContext.getString(R.string.photo), new DialogInterface.OnClickListener() { 

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub          
                mc.animateTo(geoPoint);
            }

        });