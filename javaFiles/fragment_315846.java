int exit = 0;

do {
  ...
  if (error <= 0.01) {
    exit++;
  }
} while (exit < 2);