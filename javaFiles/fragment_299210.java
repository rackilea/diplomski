case DragEvent.ACTION_DROP:
          ViewGroup owner = (ViewGroup) view.getParent();
          owner.removeView(view);
          LinearLayout container = (LinearLayout) layoutview;
          container.addView(view);
          view.setVisibility(View.VISIBLE);
          if(container.getId()==R.id.bottom_container){
              view.setOnTouchListener(null);
              owner.setOnDragListener(null);
          }
  break;