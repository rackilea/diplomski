class WorkerRepository {
    @Autowired ActorMapper actorMapper;
    @Autowired WriterMapper writerMapper;

    public Actor getActorByName(String name) {
        return actorMapper.getByNae(name, 'actor');
    }

    public Writer getWriterByName(String name) {
        return writerMapper.getByNae(name, 'writer');
    }
}