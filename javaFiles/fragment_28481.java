int c = -1;
    switch (s.hashCode()) {
      case 65: // +1 branch
        if (s.equals("I")) // +2 branches
          c = 0;
        break;
      case 73: // +1 branch
        if (s.equals("A")) // +2 branches
          c = 1;
        break;
      case 90: // +1 branch
        if (s.equals("Z")) // +2 branches
          c = 2;
        break;
      case 64594: // +1 branch
        if (s.equals("ABS")) // +2 branches
          c = 3;
        break;
      case 72639: // +1 branch
        if (s.equals("IND")) // +2 branches
          c = 4;
        break;
      default: // +1 branch
    }
    switch (c) {
      case 0: // +1 branch
        return 1;
      case 1: // +1 branch
        return 2;
      case 2: // +1 branch
        return 3;
      case 3: // +1 branch
        return 4;
      case 4: // +1 branch
        return 5;
      default: // +1 branch
        return 6;
    }