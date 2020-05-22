boolean inside = false;

  for (int i = 0; i < values.length; i++) {
      if (inside) {
        if (values[i] != values[i - 1]) {
            System.out.print(')');
            inside = false;
        }

      } else {
        if (i < values.length - 1) {
            if (values[i + 1] == values[i]) {
                System.out.print('(');
                inside = true;
            }
        }
      }
      System.out.print(values[i]);
  }