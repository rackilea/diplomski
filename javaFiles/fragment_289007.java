int spread(m, n)
{
    Queue q;
    int count = 1;

    q.push(m, n);

    while (!q.empty()) {
        int m, n;

        q.pull(&m, &n);

        if (n <= NN && m <= MM) {
            if (n != m && m <= NN) count++;
            count++;

            q.push(2*m - n, m);
            q.push(2*m + n, m);
            q.push(m + 2*n, n);
        }
    }

    return count;
}

int main()
{
    Queue q;
    int count = 1;

    count += spread(2, 1);
    count += spread(3, 1);

    printf("%d\n", count);

    return 0;
}