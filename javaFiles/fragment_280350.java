int sum = 0;
    List list = new ArrayList<String>();
    KEY.set(key);

    for (Text value : values) {
        String[] splitString = value.toString().split("\t");
        String line = splitString[0] + "\t" + splitString[1];

        sum += Integer.parseInt(splitString[1]);

        if (sum < 100) {
            list.add(line);
        } else {
            if (!list.isEmpty()) {
                for (String val: list) {
                   VALUE.set(val);
                   context.write(KEY, VALUE);
                }
                list.clear();
            }
            VALUE.set(line);
            context.write(KEY, VALUE);
        }
    }