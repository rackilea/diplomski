button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            intent = new Intent(v.getContext(), OtherActivity.class);
                intent.putExtra("imageUri", imageURI);    
                startActivity(intent);
            }
        });