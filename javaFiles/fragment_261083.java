int a[] = {3,4,6,2,1};
int size = sizeof(a)/sizeof(a[0]);
std::sort(a, a+size);
do {
  // print a's elements
} while(std::next_permutation(a, a+size));