void function(int& intByReference) {
    cout<<&intByReference<<endl; //prints x
}

int main() {
    int n = 0;
    cout<<&n<<endl; //prints x
    function(n);
}