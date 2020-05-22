ArrayList<Integer> results = new ArrayList<Integer>();
results.add(n);
if (n == 1) return results;

int next;
if (n % 2 == 0) next = n / 2;
else next = 3*n + 1; 
results.add(next);

while (next != 1) {
    if (next % 2 == 0) next = next / 2;
    else next = 3*next + 1; 
    results.add(next);
} 
return results;