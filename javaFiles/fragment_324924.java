appAdapter = new AppAdapter(context, getInstalledApps());
            final LinearLayoutManager layoutManager = new LinearLayoutManager(context);
            recyclerInstalledApps.post(new Runnable() {
                @Override
                public void run() {
                    recyclerInstalledApps.setLayoutManager(layoutManager);
                    LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(context, R.anim.recycler_layout_animation);

                    recyclerInstalledApps.setLayoutAnimation(controller);
                    recyclerInstalledApps.scheduleLayoutAnimation();
                    recyclerInstalledApps.setAdapter(appAdapter);
                }
            });
   appAdapter.notifyDataSetChanged();