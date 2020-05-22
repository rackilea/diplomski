@Service
@RequiredArgsConstructor
public class ReconciliationService {

    private final ReconciliationRepository reconciliationRepository;

    private final ReportSafeStoreClientService reportSafeStoreClientService;

    @Handler
    public whatever whatever() {
      ...
      getMissingReports()
    }

}