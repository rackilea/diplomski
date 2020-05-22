/**
 * These methods may in them selves take bound services as arguments helping you build your new service
 */
public ServiceInterface buildServiceInterface(AnotherBoundService service2) {
    ...
    return new ServiceImplementation(service2, someMoreArgsIfRequired)
}