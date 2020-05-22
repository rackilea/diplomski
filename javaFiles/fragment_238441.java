int main() {
    int myint;  //automatic int object is allocated and constructed
    //stuff
}   // when main ends, automatic int object is destroyed and deallocated

int main() {
    int* mypointer;  //automatic pointer object is allocated and constructed
    mypointer = new int;  //dynamic int object is allocated and constructed
    //stuff
    delete mypointer; //dynamic int object is destroyed and deallocated 
}   // when main ends, automatic pointer object is destroyed and deallocated
    // note: Pointers to _not_ delete the object they point to.

class myclass {
    //members
public:
    myclass() {} //this is the default constructor
    myclass(const myclass& rhs) {} //this is the copy constructor
    myclass& operator=(const myclass& rhs) {return *this} //this is the assignment operator
    ~myclass() {} //this is the destructor
};