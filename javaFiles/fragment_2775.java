dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);

//Show the dialog!
dialog.show();

//Set the dialog to immersive
dialog.getWindow().getDecorView().setSystemUiVisibility(
context.getWindow().getDecorView().getSystemUiVisibility());

//Clear the not focusable flag from the window
dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);