AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(A1.this);

            // setting custom layout to dialog
            LayoutInflater inflater = A1.this.getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.dialog, null);
            dialogBuilder.setView(dialogView);

            // adding text dynamically
            TextView txt = (TextView) dialogView.findViewById(R.id.textView);
            txt.setText("Put your dialogView text here.");
            ImageView image = (ImageView) dialogView.findViewById(R.id.image);
            image.setImageDrawable(getResources()
                    .getDrawable(android.R.drawable.ic_dialog_info));

            // adding button click event
            Button dismissButton = (Button) dialogView.findViewById(R.id.button);
            dismissButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });
            alertDialog = dialogBuilder.create();
            alertDialog.show();