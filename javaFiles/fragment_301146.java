use App\Repositories\PostRepository;
use App\Repositories\CommentRepository;

class PostService
{
  public function __construct()
  {
    $this->postRepo = new PostRepository;

    $this->commentRepo = new CommentRepository;
  }

  public function getPostData($id)
  {
    $post = $this->postRepo->get($id);

    $recentComments = $this->commentsRepo->getRecentComments();

    return collect(compact('post', 'recentComments'));
  }
}