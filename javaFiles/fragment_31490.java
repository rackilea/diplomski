Glide.with(this).load("url").into(imageView);

ImageView iv = (ImageView) view.findViewById(R.id.imageCourse);
        int res = context.getResources().getIdentifier(
                "image_" + course.getCourseNumber(), "drawable",
                context.getPackageName()
        );
 Glide.with(this).load(res).into(iv);