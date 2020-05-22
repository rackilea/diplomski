/**
 * Created by Prafulla Malviya on 2/25/2018.
 * Time : 2.38 AM India
 */
public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
        //init();
        //initView();
    }
}


package com.abhaya_foundation.abhayango;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Prafulla Malviya on 2/25/2018.
 * Time : 2.38 AM India
 */

public class MyView extends View {
    private Paint paint;

    public MyView(Context context) {
        super(context);

        // create the Paint and set its color
        paint = new Paint();
        paint.setColor(Color.GRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLUE);
        canvas.drawCircle(200, 200, 100, paint);
    }

}