public class MockWidgetRepository implements WidgetRepository{
    Map<Long, Widget>                   backingMap = new HashMap<>();

    @Override
    public <S extends Widget> S save(S entity) {
        backingMap.put(entity.getId(), entity);

        return entity;
    }

    @Override
    public <S extends Widget> List<S> save(Iterable<S> entites) {
        return null;
    }

    @Override
    public Widget findOne(Long id) {
        Widget result = backingMap.get(id);
        return result;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public List<Widget> findAll() {
        List<Widget> result = new ArrayList<>();

        result.addAll(backingMap.values());

        return result;
    }

    @Override
    public Iterable<Widget> findAll(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(Widget entity) {

    }

    @Override
    public void delete(Iterable<? extends Widget> entities) {

    }

    @Override
    public void deleteAll() {
        backingMap.clear();
    }

    @Override
    public List<Widget> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Widget> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Widget> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends Widget> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends Widget> S findOne(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Widget> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Widget> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Widget> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Widget> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Widget> boolean exists(Example<S> example) {
        return false;
    }
}