@WebService
@SOAPBinding(style = Style.RPC)
public interface ILegacyService extends IOtherLegacyService {
    // the interface methods
    ...
}

@Stateless
@Local(ILegacyService.class)
@WebService(endpointInterface = "...ILegacyService", ...)
public class LegacyServiceImpl implements ILegacyService {
    // implementation of ILegacyService
}