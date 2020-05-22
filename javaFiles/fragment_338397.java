SliderLayout sliderLayout = (SliderLayout) rootView.findViewById(R.id.banner_slider);
PagerIndicator pagerIndicator = (PagerIndicator) rootView.findViewById(R.id.banner_slider_indicator);
DefaultSliderView defaultSliderView = new DefaultSliderView(getContext());

    defaultSliderView
        .description(name)
        .image(slider_covers.get(name))
        .setScaleType(BaseSliderView.ScaleType.Fit);

    sliderLayout.addSlider(defaultSliderView);
    sliderLayout.setCustomIndicator(pagerIndicator);