String message = "";  
holder.text_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message = textview.getText().toString();
                Toast.makeText(getActivity(), "Message : " + message, Toast.LENGTH_LONG).show();

            }
        });