public class SampleActivity extends AppCompatActivity implements ISampleView {

    // ...

    public void onClick(View view){
        ISamplePresenter presenter = new SamplePresenter(this);
        presenter.buttonClicked();
    }

    @override
    public void navigateToNextView() {
        Intent intent = new Intent(this, nextActivity);
        startActivity(intent);
    }

}