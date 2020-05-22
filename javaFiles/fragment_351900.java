@Override
    public void onTargetRecognized(final Tracker tracker_, final String targetName_) {

             Intent i = new Intent(ArchitectView.this, yourActivityClass.class);
             startactivity(i);
    }