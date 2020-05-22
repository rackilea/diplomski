public class ActivityTest extends AppCompatActivity {
ImageButton eletron,center;
ArrayList<Ponto> pontos = new ArrayList<>();
int contagem = 0;
DemoRelativeLayout rel;
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.so_demo);
    eletron = (ImageButton) findViewById(R.id.tela_atomo_eletron_0);
    center = (ImageButton) findViewById(R.id.tela_atomo_maca_central);
    rel = (DemoRelativeLayout)findViewById(R.id.demo);
    //Getting all points in the ellipse
    for(int i=0;i<360;i++) {
        double x = (200 * Math.cos(i));
        double y = (400 * Math.sin(i));

        Ponto p = new Ponto(x,y);
        pontos.add(p);
    }
    eletron.postDelayed(eletronRunnable,2000);
}

@Override
protected void onStart() {
    super.onStart();
    rel.drawCircle(pontos,center.getX() + center.getWidth()/2,center.getY() + center.getHeight()/2);
    rel.invalidate();
}

Runnable eletronRunnable = new Runnable() {
    @Override
    public void run() {
        if (contagem < 360) {
            Ponto p = pontos.get(contagem);
            contagem++;
            /*RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) eletron.getLayoutParams();
            params.rightMargin = (int)p.getX();
            params.bottomMargin = (int)p.getY();
            eletron.setLayoutParams(params);*/
            eletron.setTranslationX((float) p.getX() + (eletron.getWidth()/2 + center.getWidth()/2));
            eletron.setTranslationY((float)p.getY() + (eletron.getHeight()/2 + center.getHeight()/2));
            eletron.postDelayed(this,100);
        }else {
            contagem = 0;
            eletron.postDelayed(this,100);
        }
    }
};

public class Ponto {

    private double x,y;

    public Ponto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}