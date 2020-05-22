import android.app.Activity;
    import android.content.Intent;
    import android.graphics.Color;
    import android.os.Bundle;
    import android.view.View;
    import android.view.View.OnClickListener;
    import android.widget.Button;

    public class DisplayColorsActivity extends Activity {

    private String color = "#ff0000";
    private static final  int COLOR_SELECTOR=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.colorselector);
        Button selectColorButton = (Button) findViewById(R.id.returnButton);

  String color= getIntent().getExtras().getString("selectedColor");
                    selectColorButton.setBackgroundColor(Color.parseColor(color));


 selectColorButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent request =new Intent(DisplayColorsActivity.this, MainActivity.class);
                startActivity(request);
            }
        });
    }