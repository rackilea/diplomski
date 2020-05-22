import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

/**
 * Created by Magesh on 5/4/2017.
 */

public class SampleActivity extends AppCompatActivity implements View.OnClickListener
{
    private CardView mCardView;
    private Button mBtnClick;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample);
        mCardView = (CardView) findViewById(R.id.createsub_card);
        mBtnClick = (Button) findViewById(R.id.button);
        mBtnClick.setOnClickListener(this);
       // mCardView.setCardBackgroundColor(getResources().getColorWrongWay(R.color.color_black));
        setColor(R.color.color_black);//hex color code id #000000
        mCardView.setCardBackgroundColor(getColorWrongWay());// you set like this
    }


    private int mColor = 0;
    private void setColor(int color)
    {
        mColor = color;
    }

    private int getColorWrongWay()
    {
        return mColor;
    }

    private int getColorCrtWay()
    {
        return getResources().getColor(mColor);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.button:
            {
                mCardView.setCardBackgroundColor(getColorCrtWay());// should be like this.
            }
            break;
        }
    }
}