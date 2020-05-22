@RequestMapping('/authors')
@RestController
class AuthorController {

    @RequestMapping('/{id}')
    Author singleResource(@PathVariable Author id) {
        id
    }
}