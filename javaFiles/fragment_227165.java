n = 1;
x = 0;
p = 1;
while(p > 10e-6)
    y = x;
    sum = 0;
    m=n;
    while (m > 0)
        sum = sqrt(sum + m);
        m = m - 1;
    end
    x = sum;
    p = (x-y);
    n = n + 1;
end
fprintf('Value of given expression: %.16f\n', x);
fprintf('Iterations required: %d\n', n);