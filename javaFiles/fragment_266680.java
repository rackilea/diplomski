if (matcher.find()) {
    String name = delimitedStrings[0];
    String code = delimitedStrings[1];

    mTaskData.add(new MyData(name, code));                    
}