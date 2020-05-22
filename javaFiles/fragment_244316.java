class DateDialog {
    interface DismissListener {
        void onDismiss(boolean hasDate)
    }

    private DismissListener listener = null;

    public void setDismissListener(DismissListener listener) {
        this.listener = listener;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (listener != null) {
            listener.onDismiss(HasDate);
        }
    }
}