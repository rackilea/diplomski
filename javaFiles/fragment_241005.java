import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.text_view);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hasBackground(v)) {
                    v.setBackground(null);
                } else {
                    v.setBackgroundResource(R.drawable.draw_cross);
                }
            }
        });
    }

    private boolean hasBackground(View v) {
        return v.getBackground() != null;
    }
}