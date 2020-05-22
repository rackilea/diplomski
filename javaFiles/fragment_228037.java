btn_cat.setOnClickListener(new  View.OnClickListener(){
                public void onClick(final View view){
                    AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext(),R.style.AlertDialogTheme);
                    final EditText edittext = new EditText(getContext());
                    alert.setTitle("New Category");

                    alert.setView(edittext);

                    alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            //What ever you want to do with the value

                            String newCat = edittext.getText().toString();

        valuesArrayList.add(newCat);
        adapter_exp.notifyDataSetChanged();
                        }
                    });

                    alert.show();
                }
            });

    ArrayList<String> valuesArrayList = new ArrayList<>;
    valuesArrayList.add("- Select Category -");
    valuesArrayList.add("Entertainment");
    valuesArrayList.add( "Drink & Food");
    valuesArrayList.add(  "Gift" );
    valuesArrayList.add( "HouseHold" );




            Spinner spinner = (Spinner) view.findViewById(R.id.spinner_exp);
            ArrayAdapter<String> adapter_exp = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, valuesArrayList);
            adapter_exp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
            spinner.setAdapter(adapter_exp);
            adapter_exp.notifyDataSetChanged();
           // adapter_exp.add(newCat);
            // Inflate the layout for this fragment
            return view;

        }