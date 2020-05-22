viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
        @Override
        public void transformPage(View page, float position) {
            ViewCompat.setPivotY(page,0);
            ViewCompat.setPivotX(page,page.getWidth()/2);
            float endTranslation = 0f;
            float startTranslation  = -400f;
            float deltaTranslation = endTranslation - startTranslation;

            float endScale = 1f;
            float startScale = 0.8f;
            float deltaScale = endScale - startScale;

            float progressStart = 0.5f;
            float progressEnd = 1f;
            float progressDelta = progressEnd - progressStart;

            float progress = (position - progressStart)/progressDelta;
            if(progress>1)progress=1;
            if(progress<0)progress=0;

            progress = 1-progress;

            float currentScale = startScale + deltaScale*progress;
            ViewCompat.setScaleX(page, currentScale);
            ViewCompat.setScaleY(page, currentScale);

            float currentTranslation = startTranslation + deltaTranslation*progress;
            ViewCompat.setTranslationY(page, currentTranslation);
        }