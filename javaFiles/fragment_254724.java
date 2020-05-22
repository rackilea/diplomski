button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ViewGroup.MarginLayoutParams) image.getLayoutParams()).topMargin += 1;
                image.setRotation(image.getRotation() + 1);
                image.requestLayout();