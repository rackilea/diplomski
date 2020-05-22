CustomDialogFragment dialog = new CustomDialogFragment(this);
                Bundle bundle = new Bundle();
                bundle.putInt("dialog_id", CustomDialogFragment.DATE_PICKER);
                bundle.putInt("year", mYear);
                bundle.putInt("month", mMonth);
                bundle.putInt("day", mDay);
                dialog.setArguments(bundle);
                dialog.setCancelable(false);
                dialog.show(this.getSupportFragmentManager(), "dialog");