Toast toast = Toast.makeText(activity, msg, length);
View view = toast.getView();
view.setRotation(180);
toast.setView(view);

return toast;