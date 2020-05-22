List<YourObject> data; // your data list for RecycleView

   // CALL this code after set adapter for RecycleView
   Handler h = new Handler();
   int currentAnim = Android.Resource.Animation.SlideInLeft;
   Action myAction = () => 
   {     
      // assume you use LinearLayoutManager  for RecyecleView
        View itemView = linearLayoutManager.findViewByPosition(0);
        StartAnimation(itemView, 0);
   };

   h.PostDelayed(myAction, 1000);


   private void StartAnimation(View view, int position)
    {

        Animation anim = AnimationUtils.LoadAnimation(mContext, currentAnim);
        anim.SetInterpolator(mContext, Android.Resource.Interpolator.Bounce);
        view.StartAnimation(anim);
        anim.AnimationEnd += (sender, e) =>
        {
            // animate next item

            ++position;
            if (position < data.size()) // data is your array list
            {

                // assume you use LinearLayoutManager  for RecyecleView
                View itemView = linearLayoutManager.findViewByPosition(position);
                if (itemView != null)
                {
                    StartAnimation(itemView, position);
                }
            }
        }
    }