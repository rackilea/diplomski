builder.setNeutralButton("View Data", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent myIntent = new Intent(getActivity(), SensorDataDisplay.class);
                    myIntent.putExtra("key", "TEST VALUE"); //Optional parameters
                    getActivity().startActivity(myIntent);
                }
            });