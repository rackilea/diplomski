private void setupBadge() {
    spref = new SharedPref(this); // This line initializes spref object.
    int counter = spref.GetInt(localPref.TOTALNOTIF); // here, spref was null because, it wasn't initialized yet.
    context=this;
    notif_badge.setText(String.valueOf(Math.min(counter,99)));
}