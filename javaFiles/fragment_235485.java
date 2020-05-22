class PostApplicationService {
   @Transactional
   public void publishUserPosts(Post post){
      postRepository.save(post);
      publishService.notifyNewPost(post);
   }
}