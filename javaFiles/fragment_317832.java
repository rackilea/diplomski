class CoolActivity... implements Callback

onCreate {
    //find your views
    showDialogBtn.setOnClickListener(...
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment prev = getSupportFragmentManager().findFragmentByTag("yourTag");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        DialogFragment dialogFragment = ExampleDialogFragment.newInstance();
        dialogFragment.show(ft, "yourTag");
     )
}


@Override
updateText(String text) {
    youtView.setText(text)
}