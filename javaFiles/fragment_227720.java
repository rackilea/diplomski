private RecommendationClickListener mRecommendationClickListener;


    public void setRecommendationClickListener(RecommendationClickListener recommendationClickListener) {
        this.mRecommendationClickListener = recommendationClickListener;
    }

View recommendationLayout = view.findViewById(R.id.recommendation_layout);
    recommendationLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mRecommendationClickListener != null) {
                mRecommendationClickListener.onRecommendationClicked();
            }
        }
    });