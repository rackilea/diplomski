public class NoticiaService extends Sincronizable {

private String mLanguaje;
@Inject
public  NoticiaService(Context context,String languaje, int postPorPage,int pagina)
{
    super(context);