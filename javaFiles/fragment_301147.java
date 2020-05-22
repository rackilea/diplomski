use App\Models\Post;

public function PostRepository
{
  public function get()
  {
    return Post::findOrFail($id);
  }
}