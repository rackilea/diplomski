if (view.getTypeface() == null) {
    Log.e(this.class.getName(), "No textStyle defined in xml");
    // handle?
}
if (view.getTypeface().isBold()) {
    view.setTypeface(apercuBold, Typeface.BOLD);
} else if (((TextView) view).getTypeface() == Typeface.DEFAULT) {
    view.setTypeface(apercu);
}