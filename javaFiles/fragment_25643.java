class Rectangle
{
  public:
    virtual double getHeight() = 0;
    virtual double getWidth() = 0;
    double getHeight(){
        return getWidth()*getHeight();
    }
};

class Container(){
  public:
    virtual void printTypes() = 0;
    virtual void printEachElement() =0;
};