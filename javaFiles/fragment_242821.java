private Set<ExamPaper> examPapers = new HashSet<ExamPaper>();

 @OneToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER,  mappedBy='examination')
 public Set<ExamPaper> getExamPapers() {
  return examPapers;
 }