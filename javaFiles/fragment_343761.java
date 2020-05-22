public class NonFreezingEditText extends AppCompatEditText {

    public NonFreezingEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean getFreezesText() {
        return false;
    }

}