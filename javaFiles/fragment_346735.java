class Sub: public Base {
    public:
        void A(int);
};
void Sub::A(int i) {
    std::cout << “Hey, La!\n”;
}
void main () {
    Sub a;
    a.A(1);
    a.A(1, 1);//won't compile
}