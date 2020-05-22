View v = getLayoutInflater().inflate(R.layout.order_detail_image_view, null);
settingsDialog.setContentView(v);
            Context context = settingsDialog.getContext();
            settingsDialog.show();
ImageView imgView = (ImageView) v.findViewById(R.id.imgOrderDetails);
            Picasso.with(context).load("http://i.imgur.com/Tnendik.png").into(imgView);