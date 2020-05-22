private Examination examination;

 @ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
 @JoinColumn(name="examination_id")
 public Examination getExamination() {
    return examination;
 }