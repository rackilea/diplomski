if(letter.equalsIgnoreCase("A")){
    List<Strudents> sList = studentList.stream()
            .peek(s -> System.out.println(s.getLetterGrade())) // just for debugging purpose
            .filter(s -> s.getLetterGrade().contains("A")) // why not equals? Is it one letter only?
            .collect(Collectors.toList());
}