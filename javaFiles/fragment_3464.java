// Color.hpp
class Color
{
  public:
    Color(float r_, float g_, float b_) : r(r_), g(g_), b(b_) {}
  private: // or not...
    float r;
    float g;
    float b;

  public:
    static const Color RED;
    static const Color GREEN;
    static const Color BLUE;
};

// Color.cpp
const Color Color::RED(1,0,0);
const Color Color::GREEN(0,1,0);
const Color Color::BLUE(0,0,1);