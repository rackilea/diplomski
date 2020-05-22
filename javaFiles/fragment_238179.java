public class ToggleRD extends RadioButton {
    // Implement necessary constructors

    public ToggleRD(Context context) {
        super(context);
    }
    public ToggleRD(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public ToggleRD(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void toggle() {
        if(isChecked()) {
            if(getParent() instanceof RadioGroup) {
                ((RadioGroup)getParent()).clearCheck();
            }
        } else {
            setChecked(true);
        }
    }
}