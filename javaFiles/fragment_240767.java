case MotionEvent.ACTION_UP:
    moving=false;

    if(y < 100){
       high.setVisibility(View.Visible);
    }else if(y < 200){
       perfect.setVisibility(View.Visible);
    }else{
       low.setVisibility(View.Visible);
    }

    break;
}