List<String[]> output = new ArrayList<String[]>();
// populate output with arrays containing three elements 
// which will be used used to initialize Page instances
//...

List<Page> result = output.stream()
                          .map(arr -> new Page(arr[0], arr[1], arr[2]))
                          .collect(Collectors.toList());