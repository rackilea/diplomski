imageView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              // Code to show image in full screen:
              new PhotoFullPopupWindow(context, R.layout.popup_photo_full, view, URL, null);

          }
      });