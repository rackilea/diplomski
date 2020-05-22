import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Drugfragment extends Fragment {
    View view;


    public Drugfragment() {


    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.drugfragment, container, false);

        final Spinner spin1 = view.findViewById(R.id.spinnerFrequency);
        final Spinner spin2 = view.findViewById(R.id.SpinnerTime);
        final Spinner spin3 = view.findViewById(R.id.SpinnerQty);
        Button save = view.findViewById(R.id.btnSave);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(getContext(), R.array.Qty, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> arrayAdapter2 = ArrayAdapter.createFromResource(getContext(), R.array.time, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> arrayAdapter3 = ArrayAdapter.createFromResource(getContext(), R.array.frequency, android.R.layout.simple_spinner_item);


        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(arrayAdapter);
        spin2.setAdapter(arrayAdapter2);
        spin3.setAdapter(arrayAdapter3);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = spin1.getSelectedItem().toString();
                String text2 = spin2.getSelectedItem().toString();
                String text3 = spin3.getSelectedItem().toString();
                Toast.makeText(getContext(), "text1: " + text + "\ntext2: " + text2 + "\ntext3: " + text3, Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}