class Button {
public:
    template <typename F>
    Button(F&& f) : cb(std::forward<F>(f))
    { }

    void callback() { cb(); }

private:
    std::function<void()> cb; // type-erased functor for ANY callable
                              // that takes zero arguments
};