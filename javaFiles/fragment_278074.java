public ViewHolder(@NonNull View itemView, Context context, int[] images, ArrayList<String> mImageNames) {
        super(itemView);
        image = itemView.findViewById(R.id.image);
        imageName = itemView.findViewById(R.id.image_name);
        parentLayout = itemView.findViewById(R.id.parent_layout);

        itemView.setOnClickListener(this);
        this.context = context;
        this.images = images;
        this.mImageNames = mImageNames;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(mContext, GalleryActivity.class);
        intent.putExtra("image_url", mImages[getAdapterPosition()]);
        intent.putExtra("image_name", mImageNames.get(getAdapterPosition()));
        mContext.startActivity(intent);
    }