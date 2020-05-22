import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.innovanathinklabs.sample.BuildConfig;
import com.innovanathinklabs.sample.R;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tvVersion = findViewById(R.id.tvVersion);
        if (tvVersion != null) tvVersion.setText(BuildConfig.VERSION_NAME);
    }
}