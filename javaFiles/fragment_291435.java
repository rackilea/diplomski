@Validated
class PostService {
   public Post save(@Valid Post post) {
       return postRepository.save(post);
   }
}