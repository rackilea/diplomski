enum Status {

    TO_BE_DONE(R.string.to_be_done),
    PENDING(R.string.pending),
    COMPLETED(R.string.completed);

    private final int mStringResource;

    private Status(final int stringResource) {
        mStringResource = stringResource;
    }

    public String asString(final Context context) {
        return context.getString(mStringResource);
    }

}