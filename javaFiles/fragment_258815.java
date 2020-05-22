@Service
public class EventServiceImpl implements EventService {

    @Override
    public Iterable<Event> findByName(String name) {
        return eventRepository.findByName(name);
    }

    @Override
    public Iterable<Event> searchForName(String name) {
        return eventRepository.findByNameContainingIgnoreCase(name);
    }

}