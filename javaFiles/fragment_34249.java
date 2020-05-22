class test {
    int* array;
    size_t size;
public:
    test(size_t n) : array(new int[n]), size(n)
    {
        for (int i = 0; i < n; i++) { array[i] = i; }
    }
    ~test() { delete [] array; }
    int* begin() { return array; }
    int* end() { return array + size; }
};

int main()
{
    test T(10);
    for (auto& i : T) {
        std::cout << i;   // prints 0123456789
    }
}