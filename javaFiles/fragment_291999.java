rewardButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Constants.currentAd = "REWARD1";
                dismiss();
                ((MainActivity) getActivity()).showRewardedVideo();
            }
        });