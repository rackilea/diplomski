float N = 0;
float T = 0;
int i = 1;

void setup() {
    for (i = 1; i < 100; i += 2) {
        N = N + 1.0 / i;
        T = T + 1.0 / (i + 1);
    }
    println(N - T);
}