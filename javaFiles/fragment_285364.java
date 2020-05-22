b.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            progress = progress + 1;
            if (shownId == 1) {
                shownId = 2;
                setProgressBar();
                if(!mcFragment.isAdded()) {
                    fm.beginTransaction().add(R.id.container, mcFragment).hide(questionFragment).commit();
                }else {
                    fm.beginTransaction().hide(questionFragment).show(mcFragment).commit();
                    mcFragment.updatePosition(progress);
                }
            } else if (shownId == 2) {
                shownId = 1;
                setProgressBar();
                if(!questionFragment.isAdded()) {
                    fm.beginTransaction().hide(mcFragment).add(R.id.container, questionFragment).commit();
                }else{
                    fm.beginTransaction().hide(mcFragment).show(questionFragment).commit();
                }
            }
        }
    });