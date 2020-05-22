if(hasImage)
{
    ColorStateList sColorStatePlaying;
    ColorStateList sColorStateNotPlaying;

    sColorStatePlaying = ColorStateList.valueOf(context.getResources().getColor(R.color.colorPrimary));
    AnimationDrawable animation = (AnimationDrawable) ContextCompat.getDrawable(context, R.drawable.anim_current_song);
    ImageView EQ_ANIM = (ImageView) view.findViewById(R.id.imageView_eq_animation);
    EQ_ANIM.setVisibility(View.VISIBLE);
    EQ_ANIM.setImageDrawable(animation);
    EQ_ANIM.setImageTintList(sColorStatePlaying);
    animation.start();
}
else
{
    // Set the default image
}