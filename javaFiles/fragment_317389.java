// List<DataBean> -> Set<Integer> (set of answer codes)
Set<Integer> set = beans.stream()
                        .map(DataBean::getAnswerCode)
                        .collect(Collectors.toSet());

// List<Answer> -> filtered List<Answer>
List<Answer> result = answers.stream()
                             .filter(a -> set.contains(a.getCode()))
                             .collect(Collectors.toList());