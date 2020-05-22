public static LabColor[] makeGradient(LabColor c1, LabColor c2, int n) {
    LabColor gradient = new LabColor[n];
    for (int i = 0; i < n; i++) {
        float alpha = (float)i / (n-1);  // 0.0 <= alpha <= 1.0 
        float L = (1-alpha) * c1.L + alpha * c2.L;
        float a = (1-alpha) * c1.a + alpha * c2.a;
        float b = (1-alpha) * c1.b + alpha * c2.b;
        gradient[i] = new LabColor(L, a, b);
    }
    return gradient;
}