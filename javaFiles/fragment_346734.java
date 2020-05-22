class Base {
    public:
        virtual void A (int);
        virtual void A (int, int);
};
void Base::A(int i) {
    std::cout << “Hi\n”;
}
void Base::A (int i, int j) {
    std::cout << “Bye!!\n”;
}