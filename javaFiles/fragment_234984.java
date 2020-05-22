mBottomSheet.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mSlideUpPanel != null &&
                    (mSlideUpPanel.getPanelState() == SlidingUpPanelLayout.PanelState.COLLAPSED || mSlideUpPanel.getPanelState() == SlidingUpPanelLayout.PanelState.ANCHORED)) {
                mSlideUpPanel.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
            }
            if (mSlideUpPanel != null &&
                    (mSlideUpPanel.getPanelState() == SlidingUpPanelLayout.PanelState.EXPANDED || mSlideUpPanel.getPanelState() == SlidingUpPanelLayout.PanelState.ANCHORED)) {
                mSlideUpPanel.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            }
        }

    });