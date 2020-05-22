make changes as per your need


        Animation animation = new TranslateAnimation(0, 500,0, 0);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        yourButton.startAnimation(animation);
        yourButton.setVisibility(0);

    OR
    You can create Translate animation using ObjectAnimator. check link for more information

    ObjectAnimator transAnimation= ObjectAnimator.ofFloat(YourButton, propertyName, fromX, toX);
    transAnimation.setDuration(3000);//set duration
    transAnimation.start();//start animation

Example
ObjectAnimator anim = ObjectAnimator.ofFloat(yourButton, "translationX", 0,200); and then 
 anim.setDuration(3000);
 anim.start();