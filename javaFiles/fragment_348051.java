template <class Food>
class Consumer {
 public:
  std::function<void(Food)> accept;

  template <class Eater>
  Consumer<Food>(Eater consume) : accept(consume){};
};