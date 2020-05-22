Pattern pattern = Pattern.compile("(?<!\\$\\[)(\\w+)(?!\\])");
pathList = pathList.stream().map(path -> {
    Matcher m = pattern.matcher(path.toString());
    return m.find() ? m.group(0) : null;
}).collect(Collectors.toList());
System.out.println(pathList); // [contractor, fullTimeStaff]