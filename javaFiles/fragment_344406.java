ImageButton.setOnLongClickListener(new OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(null, shadowBuilder, v, 0);
                deleteAreaForAdapter.setVisibility(View.VISIBLE);
                deleteAreaForAdapter.startAnimation(slide_in);
                v.setVisibility(View.INVISIBLE);
                return true;
            }
        });