public class ExtratoDespesasCursorAdapter extends CursorAdapter{
  public BaseDadosSF dados;

  public ExtratoDespesasCursorAdapter(Context context, Cursor c) {
    super(context, c, 0);
    dados = new BaseDadosSF(context);
  }