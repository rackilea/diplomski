use App\Services\PostService;

class PostController
{
  public function __construct()
  {
    $this->postService = new PostService;
  }

  public function show($id)
  {
    $viewData = $this->postService->getPostData($id);

    return view('posts.show', $viewData);
  }
}