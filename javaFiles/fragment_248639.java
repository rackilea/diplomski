@Override
protected void onCreate(Bundle savedInstanceState) {  
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.activity_camera);
}

@Override
protected void onResume(){
  super.onResume();
  AlertDialog dialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getResources().getString(R.string.afericao_instrucao) +
                String.valueOf(bdl.getLauTempo()) + //this variable make my app stop woking
                getResources().getString(R.string.fotos) +
                String.valueOf(bdl.getQntFotos()) + //this variable make my app stop woking
                getResources().getString(R.string.segundos));

        builder.setPositiveButton(android.R.string.ok, null);
        dialog = builder.create();
        dialog.show();
}