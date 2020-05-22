public void swap(int i, int j)  <-- // `i` and `j` are elements A[s] and A[i]
{
    int holder = A[i];  <-- // You are accessing them as indices(A[i] -> A[A[s]])
    A[i] = A[j];
    A[j] = holder;
}