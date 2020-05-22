LayoutInflater inflater = ((HomeActivity) context).getLayoutInflater();
        View dialogLayout = inflater.inflate(R.layout.fragment_fong, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        final AlertDialog dialog = builder.create();
        dialog.setView(dialogLayout);
        dialog.show();
       // dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        final VideoView video_player_view = (VideoView) dialog.findViewById(R.id.videos);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.copyFrom(dialog.getWindow().getAttributes());
        dialog.getWindow().setAttributes(lp);

        Uri uri = Uri.parse("http://file2.video9.in/english/movie/2014/x-men-_days_of_future_past/X-Men-%20Days%20of%20Future%20Past%20Trailer%20-%20[Webmusic.IN].3gp");
        video_player_view.setVideoURI(uri);
        video_player_view.start();