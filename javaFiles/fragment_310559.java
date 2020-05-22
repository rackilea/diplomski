mSnackBar = new SnackBar.Builder(this)
    .withOnClickListener(this)
    .withMessage("Text")
    .withActionMessage("Action")
    .withStyle(SnackBar.Style.DEFAULT)
    .show();

TextView snackButton = (TextView) mSnackBar.getContainerView().
                        findViewById(R.id.snackButton); \\ now you can modify the style of action view