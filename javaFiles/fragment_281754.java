Tuple<int, int>[] test = new Tuple<int, int>[] {
    new Tuple<int, int>(2, 4),
    new Tuple<int, int>(4, 3),
    new Tuple<int, int>(6, 2),
    new Tuple<int, int>(8, 1),
  };

  // Same line
  Console.Write(SameLine(test) ? "Same line" : "different lines");