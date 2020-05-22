public class ExtratoDespesasCursorAdapter extends CursorAdapter{
  public BaseDadosSF dados = new BaseDadosSF(this); ----> the error is here

  public ExtratoDespesasCursorAdapter(Context context, Cursor c) {
    super(context, c, 0);
  }