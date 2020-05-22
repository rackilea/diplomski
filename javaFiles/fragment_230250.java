addIngredientButton.setOnClickListener(new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity().getApplicationContext(),"here",Toast.LENGTH_LONG).show();
            final String ingredient = ingredientEditText.getText().toString().trim();
            if (!TextUtils.isEmpty(ingredient)) {
                    adapter.add(ingredient);
             }

           }
        }
    });