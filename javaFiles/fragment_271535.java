public List<Integer[]> doFun(String[] input, String wantedValue) {
    List<Integer[]> output = new ArrayList<Integer[]>();
    int beginIndex = -1;
    int length = 0;
    for (int i = 0; i < input.length; i++) {
      if (!wantedValue.equals(input[i])) {
        if (beginIndex > -1) {
          output.add(new Integer[] { beginIndex, beginIndex + length });
        }
        beginIndex = -1;
        continue;
      }
      if (beginIndex < 0) {
        beginIndex = i;
        length = 0;
      } else {
        length++;
      }
    }

    if (beginIndex > -1) {
      output.add(new Integer[] { beginIndex, beginIndex + length });
    }

    return output;
  }