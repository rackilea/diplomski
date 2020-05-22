@RepositoryRestController
@RequestMapping("/myEntity")
@ExposesResourceFor(MyEntity.class)
public class MyEntityResource {
    @PostMapping(value = "", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity postResult(@RequestBody Resource<Entity> entity) {
        // my logic. Fetch the entity with entity.getContent()
    }
}