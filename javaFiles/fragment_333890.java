public class NoticiaService extends Sincronizable {

    private String mLanguaje;
    @Inject
    public  NoticiaService(Context context,String languaje, String postPorPage,String pagina)
    {
        super(context);