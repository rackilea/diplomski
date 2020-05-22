String output[] = new String[test_.length];
    String split_test[] = null;
    for (int j = 0; j < test_.length(); j++) {
        split_test = test_[j].split("\\s+");

        // use direct index
        // output2[j] = split_test[1] + " " + split_test[3];
        // or based on length
        output[j] = split_test[1] + " " + split_test[split_test.length - 2];
    }
    System.out.println(Arrays.toString(output));