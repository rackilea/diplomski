button_cook.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        final AlertDialog.Builder button_cook_action = new AlertDialog.Builder(this);
        final EditText cookMl = new EditText(this);
        cookMl.setInputType(InputType.TYPE_CLASS_NUMBER);

        button_cook_action.setTitle(R.string.kitchen_recipe_button_cook)
                .setMessage(R.string.kitchen_recipe_button_cook_volume)
                .setView(cookMl)
                .setPositiveButton(R.string.Yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog.Builder builderCooking = new AlertDialog.Builder(RecipeActivity.this);
                        builderCooking.setTitle(recipe.getName())
                        .setMessage("message");
                        builderCooking.show();
                    }
                })
                .setNegativeButton(R.string.No, null)
                .show();
    }
});