public interface TrackRepository extends CrudRepository<Track, Integer> {

    Track findByName(String name);

}

@Transactional
public TrackServiceImpl implement TrackService{
    @AutoWired
    TrackRepository trackRepository;

    List<Satz> getSatzByTrackName(String name){
         Track track = trackRepository.getByName(name);

         return track != null ? track.getSaetze() : new ArrayList<>();
    }
}