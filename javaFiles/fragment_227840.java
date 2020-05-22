final AnimatorSet set = new AnimatorSet();

final AnimatorSet subSet = new AnimatorSet();
subSet.playTogether(
        ObjectAnimator.ofFloat(ship, "translationX", rx, rx2),
        ObjectAnimator.ofFloat(ship, "translationY", ry, ry2));

set.playSequentially(
        ObjectAnimator.ofFloat(ship, "rotation", sangle, angle)
                .setDuration(1000),
        subSet.setDuration(3000));

set.start();