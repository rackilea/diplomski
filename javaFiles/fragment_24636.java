class double_it_impl
{
  public:
    double_it_impl(int x) : m_x = x; {};
    int doubling()  { m_x *= 2; return m_x; }

}


public_double_it::public_double_it(int x)
{
    pImpl = new public_double_it(x);
}

int public_double_it::doubling()
{
   return pImpl->doubling();
}