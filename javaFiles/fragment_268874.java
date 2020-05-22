import javax.inject.Inject;
public class OverviewVM extends AbstractVM {

    @Inject
    private NotaService notaService;
    @Inject
    private ContactService contactService;