public override void OnBindViewHolder(RecyclerView.ViewHolder holder, int position)
{
    myHolder = holder as MyView;
    if (position > mCurrentPosition)
    {
        Handler h = new Handler();
        int currentAnim = Android.Resource.Animation.SlideInLeft;
        Action myAction = () => 
        {
            SetAnimation(holder.ItemView, currentAnim);
        };

        h.PostDelayed(myAction, 1000);


        mCurrentPosition = position;
    }

}