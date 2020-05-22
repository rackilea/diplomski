public class AttributeWizard extends Activity {

    private LinearLayout linearLayoutAttribute;
    private LinearLayout layoutBotoes;
    private Button bNext;
    private Button bPrev;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_uisarde_attributes);

        createLayoutForButtons();

        linearLayoutAttribute = findViewById(R.id.linearLayoutAttribute);
        linearLayoutAttribute.addView(layoutBotoes);
    }


    public void createLayoutForButtons() {
        layoutBotoes = new LinearLayout(this);
        bNext = createButton();
        bNext.setText("Próximo");
        bPrev = createButton();
        bPrev.setText("Anterior");

        layoutBotoes.setOrientation(LinearLayout.HORIZONTAL);
        layoutBotoes.addView(bPrev);
        layoutBotoes.addView(bNext);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(MATCH_PARENT, 0);
        params.weight = 1;
        layoutBotoes.setLayoutParams(params);
    }

    private Button createButton() {
        Button button = new Button(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, WRAP_CONTENT);
        params.weight = 1;
        params.gravity = Gravity.BOTTOM;
        button.setLayoutParams(params);
        return button;
    }
}