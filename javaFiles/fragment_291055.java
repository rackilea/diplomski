final int AmountToMove = -(desiredHeight - mLL.getHeight());
        ObjectAnimator objAnim = ObjectAnimator.ofFloat(mLL, "translationY", AmountToMove);

        objAnim.setDuration(1000);
        objAnim.setInterpolator(new OvershootInterpolator());

        objAnim.start();