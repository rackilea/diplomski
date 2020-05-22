byte[] input = s.getBytes();
    for (int i = 0; i < input.length; ++i) {
        input[i]+= N;
    }

    String encrypted = new String(input);
    System.out.print("encrypted name is " + encrypted);