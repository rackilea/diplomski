new MaterialDialog.Builder(MainActivity.this)
                .title("Oh no!")
                .content("We've run out of pictures! Would you like to start over or check if a new picture has been uploaded?")
                .positiveText("Check again")
                .negativeText("Start over")
                .callback(new MaterialDialog.ButtonCallback() {
                    @Override
                    public void onPositive(MaterialDialog dialog) {
                        getImage();
                    }

                    @Override
                    public void onNegative(MaterialDialog dialog) {
                        int imageNr=1;
                        SharedPreferences.Editor editorsave = sharedPreferences.edit();
                        editorsave.putInt("ImageNr", imageNr);
                        editorsave.apply();
                        getImage();
                    }
                }).show();