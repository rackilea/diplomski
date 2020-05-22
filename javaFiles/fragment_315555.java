import android.view.View;

public class CanvasItem { //notice does not need to implement onClickListener

    //this is used to get the click
    private View.OnClickListener onClickListener;

    protected CanvasItem(){
      /* contructor logic goes here */
      /* at minimum x and y and width and height is needed */
    }

    protected boolean isHit(float x, float y){
        /* left() right() top() and bottom() use widths and height from my constructor */
        /* x and y is passed from canvas ontouch */
        if(x >= left() && x <= right() && y >= top() && y <= bottom()){

            //fire any onclick listeners
            if(onClickListener != null){
                onClickListener.onClick(null);
            }

            //return true
            return true;
        }

        //not touched
        return false;
    }

    protected void setOnTouchListener(View.OnClickListener clickListener){
        onClickListener = clickListener;
    }
}