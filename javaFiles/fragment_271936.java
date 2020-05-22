AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    inflater = getActivity().getLayoutInflater();
    builder.setTitle("Identity verification");
    // Inflate and set the layout for the dialog
    v = inflater.inflate(R.layout.input_dialog, null);
    builder.setView(v);
    builder.setPositiveButton("Modify account", new DialogInterface.OnClickListener() 
    {
               public void onClick(DialogInterface dialog, int id) 
               {

                 email_field   = 
                 ...
                 ...