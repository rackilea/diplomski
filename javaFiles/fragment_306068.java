CustomDialogFragment dialog = new CustomDialogFragment(YourFragment.this);
    Bundle bundle = new Bundle();
    bundle.putInt("dialog_id", CustomDialogFragment.DATE_PICKER);
    bundle.putInt("year", mYear);
    bundle.putInt("month", mMonth);
    bundle.putInt("day", mDay);
    dialog.setArguments(bundle);
    dialog.show(getFragmentManager(), "dialog");