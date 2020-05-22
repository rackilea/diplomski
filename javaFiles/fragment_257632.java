public class FragBeamRec extends Fragment implements OnCalcComplete {
    public void onCalculationComplete(int result) {
        textView.setText(result);
    }
...
}