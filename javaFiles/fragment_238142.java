import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DietFragment extends Fragment {

    Button button;
    TextView mealOne;

    public int mealId;

    public DietPlan dietPlan = new DietPlan();

    HttpRequestDietPlan hrt = new HttpRequestDietPlan();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_diet, null);

        ET = rootView.findViewById(R.id.targetCalories_Input);
        Tv1 = rootView.findViewById(R.id.targetCalories_Output);
        button = rootView.findViewById(R.id.testButton);
        mealOne = rootView.findViewById(R.id.meal1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hrt.getJson(new HttpRequestDietPlan.CallHandler(
                    @Override
                    public void onFailure(Exception e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onSuccess(DietPlan dietPlan) {
                        mealId = hrt.dietPlan.meals.get(0).mealId;
                        title = hrt.dietPlan.meals.get(0).title;
                        mealOne.setText(title);
                    }
                ));
            }
        });

        return rootView;
    }
}