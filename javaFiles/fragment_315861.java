getConfirmDialog(getString(R.string.logout), getString(R.string.logout_message), getString(R.string.yes), getString(R.string.no), false,
                new AlertMagnatic() {

                    @Override
                    public void PositiveMethod(final DialogInterface dialog, final int id) {}

                    @Override
                    public void NegativeMethod(DialogInterface dialog, int id) {

                    }
                });