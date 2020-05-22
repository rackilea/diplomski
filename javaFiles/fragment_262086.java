vHolder.menu_play.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            menu_dialog = v.getRootView().findViewById(R.id.menu_dialog);
            menu_dialog.setVisibility(v.VISIBLE);

            activity.initAudio(v.getContext(), mData.get(vHolder.getAdapterPosition()).getURL());
            activity.setMargins(v.getRootView().findViewById(R.id.viewpager_id), 0,0,0,100);
        }
    });