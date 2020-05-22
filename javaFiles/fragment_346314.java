@Autowired
 ActorRepository actorRepository;

 Optional<Actor> actorOptional = actorRepository.findById(id);
 if(actorOptional.isPresent()){
     movie.getActors().add(actorOptional.get());
 }else{
   // create new actor and add it to the list
 }