AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());       
    LayoutInflater inflater = getActivity().getLayoutInflater();

    builder.setView(inflater.inflate(R.layout.activity_schedule_select_dialog, null))
        .setPositiveButton(R.string.ssd_select_positive, new DialogInterface.OnClickListener()
        {               
            public void onClick(DialogInterface dialog, int which)
            {
                mListener.onDialogPositiveClick(DFrag.this);                        
            }
        })
        .setNegativeButton(R.string.select_negative, new DialogInterface.OnClickListener()
        {               
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mListener.onDialogNegativeClick(DFrag.this);
                DFrag.this.getDialog().cancel();                        
            }
        });