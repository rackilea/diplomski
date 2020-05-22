@Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.addMusicButton:
                confirmAddButton.setVisibility(View.VISIBLE);
                newMusic.setVisibility(View.VISIBLE);
                addMusicButton.setVisibility(View.GONE);
                break;
            case R.id.confirmAddButton:
                (...)
                break;
        }
    }