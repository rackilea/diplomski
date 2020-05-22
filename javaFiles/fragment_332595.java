@Cacheable(value = USER_ENTITY_1_CACHE)
public List<MyEntity1> findEntities1(Long userId) {
//...
}
And:

@Cacheable(value = USER_ENTITY_2_CACHE)
public Set<MyEntity2> findEntities2(Long userId) 
{
    //..
}