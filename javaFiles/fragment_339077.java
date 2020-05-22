String[] titles = {
        "1 Introduction",
        " 1.1 Scope",
        " 1.2 Relevance",
        "    1.2.1 Advantages",
        "      1.2.1.1 Economic",
        "    1.2.2 Disadvantages",
        "2 Analysis",
    };
    for (int i = 0; i < titles.length; i++) {
        System.out.println(String.format("%-30s %4d",
            titles[i],
            i * i * i // just example formula
        ));
    }