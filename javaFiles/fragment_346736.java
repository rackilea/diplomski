class Sub: public Base {
    public:
        void A(int);
        using Base::A;
};
void Sub::A(int i) {
    std::cout << “Hey, La!\n”;
}
void main () {
    Sub a;
    a.A(1);
    a.A(1, 1);//will compile
}