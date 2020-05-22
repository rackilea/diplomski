Info[] max = new Info[10];
    int count = 0;
    while ((line = br.readLine()) != null) {

        // use comma as separator(There is 11 column)
        String[] column = line.split(cvsSplitBy);
        Info info = new Info(column, mod);
        if (count > 0 && !max[0].time.equals(info.time)) {
            printPeriod(max, count, fileWriter);
            count = 0;
        }
        int i = 0;
        while (i < count && max[i].frq > info.frq) {
            ++i;
        }
        while (i < count) {
            Info pred = max[i];
            max[i] = info;
            info = pred;
            ++i;
        }
        if (count < max.length) {
            max[count++] = info;
        }
    }
    if (count > 0) {
        printPeriod(max, count, fileWriter);
    }