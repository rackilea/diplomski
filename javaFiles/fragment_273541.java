private void flipcard(final RecyclerView.ViewHolder holder)
    {
        final MyHolder myHolderflipcard= (MyHolder) holder;

        String nim=mysr_id.get(Integer.parseInt(mpref.getradio_button_value()));
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(nim);
        if (matcher.find())
        {
            currentsrid=Integer.parseInt(matcher.group(0));

            if (currentsrid!=flag)
            {
                flag = Integer.parseInt(matcher.group(0));
                // Delete old fragment
                int containerId = myHolderflipcard.container.getId();// Get container id
                Fragment oldFragment = ((FragmentActivity) context).getFragmentManager().findFragmentById(containerId);
                if(oldFragment != null)
                {
                    ((FragmentActivity) context).getFragmentManager().beginTransaction().remove(oldFragment).commit();
                }
                int newContainerId = 0;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    newContainerId = View.generateViewId();
                }

                // Set the new Id to our know fragment container

                myHolderflipcard.container.setId(newContainerId);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    curHolder = myHolderflipcard;
                }


                // Just for Testing we are going to create a new fragment according
                // if the view position is pair one fragment type is created, if not
                // a different one is used.


                {
                    Fragment f;
                    f = new CardBackFragment();
                    // Then just replace the recycler view fragment as usually
                    ((FragmentActivity) context).getFragmentManager().beginTransaction()
                            .setCustomAnimations(
                                    R.animator.card_flip_right_in,
                                    R.animator.card_flip_right_out,
                                    R.animator.card_flip_left_in,
                                    R.animator.card_flip_left_out)
                            .addToBackStack(null)
                            .replace(newContainerId, f).commit();
                    // Once all fragment replacement is done we can show the hidden container
                    handler.post(runnable);

                    //myHolderflipcard.container.setVisibility(View.VISIBLE);
                    //myHolderflipcard.radioGroup.setVisibility(View.GONE);
                    //myHolderflipcard.tvQuestion.setVisibility(View.GONE);
//                    myHolderflipcard.cardView.setVisibility(View.GONE);
                }

            }else
            {
               // backtoorignal=false;
                // ((FragmentActivity)context). getFragmentManager().popBackStack();
            }

        }

    }

    private MyHolder curHolder;
    private Handler handler = new Handler();

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
           Log.d("mId", String.valueOf(curHolder.container.getId()));
            curHolder.cardView.setVisibility(View.GONE);
        }
    };