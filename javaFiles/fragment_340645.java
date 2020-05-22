public static void main(String[] args) {
    List<ErrorCodeModel> presentErrorList = new ArrayList<>();
    presentErrorList.add(new ErrorCodeModel("1000", 10, 0));
    presentErrorList.add(new ErrorCodeModel("1100", 2, 0));

    List<ErrorCodeModel> pastErrorList = new ArrayList<>();
    pastErrorList.add(new ErrorCodeModel("1003", 0, 10));
    pastErrorList.add(new ErrorCodeModel("1104", 0, 12));
    pastErrorList.add(new ErrorCodeModel("1000", 0, 12));

    Map<String, ErrorCodeModel> map = Stream.of(presentErrorList, pastErrorList)
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(ErrorCodeModel::getErrorCode,
                      Function.identity(),
                      (oldValue, newValue)
                      -> new ErrorCodeModel(oldValue.getErrorCode(),
                           oldValue.getPresentErrorCount()+newValue.getPresentErrorCount(),
                           oldValue.getPastErrorCount()+newValue.getPastErrorCount())));

    List<ErrorCodeModel> errorList = new ArrayList<>(map.values());

    errorList.sort((err1, err2) //line 20*
                -> Integer.compare(Integer.parseInt(err1.getErrorCode()),
                                   Integer.parseInt(err2.getErrorCode())));

    System.out.println(errorList.toString());

    //*line 20 : Optionnal, if you want to sort by errorCode
    //(need to parse to int to avoir alphabetical order
}