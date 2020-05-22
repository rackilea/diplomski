Dialog alert = alertDialogBuilder.create();
WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
lp.copyFrom(alert.getWindow().getAttributes());
lp.height = 100; 
lp.width = 50;
alert.getWindow().setAttributes(lp);