@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__({ @Autowired }))
public class OperatorServiceImpl implements OperatorService {

  private final WhoisService whoisService;

  ...
}