double answer = 1.0;
    for (int i = 1; i <= y; i++) {
        answer *= (x + 1 - i);
        answer /= i;           // humor 280z80
    }
    return answer;