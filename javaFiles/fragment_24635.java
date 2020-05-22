// Forward declaration of the implementation class. 
class double_it_impl;

// Class that stores an integer, and doubles it each time you 
// call doubling().
class Public_double_it
{
  public:
    public_double_it(int x);    // COnstructor. 

    int doubling();        // Function d

  private:
     double_it_impl *pImpl;
};