public class GenericTree< T >
  extends AbstractTree< T, GenericNode< T > >
{

  public GenericTree ( GenericNode< T > root )
  {
    super( root );
  }

  @Override
  public List< GenericNode< T > > postOrder ( )
  {
    ...
  }
  ...
}