public class ColorChanger {


    private int from_color;
    private int to_color;
    private int currentColor;
    private int interval=1000;//default iterval
    private ValueAnimator colorAnimation;
    private int[] colors=new int[3];

    public ColorChanger(int color1, int color2, int color3){


        colors[0]=color1;
        colors[1]=color2;
        colors[2]=color3;

        this.currentColor=0;

        from_color=colors[0];
        to_color=colors[1];

    }


    public ColorChanger run(final View view){




        colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), from_color, to_color);
        colorAnimation.setDuration(this.interval);

        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
            view.setBackgroundColor((Integer) animator.getAnimatedValue());
        }

        });

        colorAnimation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {


            from_color=colors[currentColor];



            if (currentColor+1>=colors.length){

                currentColor=0;

            }else{
                currentColor++;
            }

            to_color=colors[currentColor];

            //run again
            run(view);

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

           }
        });


        colorAnimation.start();

        return this;

    }

    public void setIntervalMs( int ms){

        this.interval=ms;

    }

}