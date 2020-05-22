public class MainActivity extends AppCompatActivity implements OnClickListener
    {

         Button start;
         Button reset;
         Button exit;
         ImageView redcar;
         ImageView bluecar;
         ImageView greencar;
         ImageView orangecar;

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            start = (Button) findViewById(R.id.start);
            reset = (Button) findViewById(R.id.reset);
            exit = (Button) findViewById(R.id.exit);

            redcar= (ImageView) findViewById(R.id.img_animation1);
            bluecar= (ImageView) findViewById(R.id.img_animation2);
            greencar= (ImageView) findViewById(R.id.img_animation3);
            orangecar= (ImageView) findViewById(R.id.img_animation4);

            start.setOnClickListener(this);
            reset.setOnClickListener(this); 
            exit.setOnClickListener(this);  
        }

        @Override
        public void onClick(View view)
        {

            switch (view.getId())
            {
                case R.id.start:
                case R.id.reset:
                    animate();
                    break;
                case R.id.exit:

                    finish();

                    break;
            }

        }


     public void animate() {
            Animation redMoveAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.car_anim);
            Animation blueMoveAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.car_anim2);
            Animation greenMoveAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.car_anim3);
            Animation orangeMoveAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.car_anim4);

            redcar.startAnimation(redMoveAnimation);
            redMoveAnimation.setFillAfter(true);

            bluecar.startAnimation(blueMoveAnimation);
            blueMoveAnimation.setFillAfter(true);

            greencar.startAnimation(greenMoveAnimation);
            greenMoveAnimation.setFillAfter(true);

            orangecar.startAnimation(orangeMoveAnimation);
            orangeMoveAnimation.setFillAfter(true);
        }

    }