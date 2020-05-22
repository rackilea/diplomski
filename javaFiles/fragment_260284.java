RelativeLayout.LayoutParams viewParams = 
                    new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, 
                            RelativeLayout.LayoutParams.WRAP_CONTENT);
                viewParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                viewParams.addRule(RelativeLayout.ALIGN_LEFT);

adView.setLayoutParams(viewParams);