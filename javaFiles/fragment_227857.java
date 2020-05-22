String value = ((TextView) 
            view.findViewById(R.id.username)).getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString("view", value);
            Intent myIntent = new Intent(view.getContext(), MainActivity.class);
            myIntent.putExtra(bundle);
            startActivityForResult(myIntent, 0);