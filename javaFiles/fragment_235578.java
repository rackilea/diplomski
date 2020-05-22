followButton.clicks()
    .doOnNext { followButton.setEnabled(false) }
    .switchMap( your network Observable or Single)
    .subscribe {
        followButton.setEnable(true);
        followButton.setText("newText");
    }