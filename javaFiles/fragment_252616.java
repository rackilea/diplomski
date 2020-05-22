@ManyToOne
    @JoinColumns({
      @JoinColumn(name = "qstn_choice_num", insertable=false, updatable=false, columnDefinition = "INT"),
      @JoinColumn(name = "assess_qstn_num", insertable=false, updatable=false, columnDefinition = "SMALLINT"),
      @JoinColumn(name = "tst_sctn_num", insertable=false, updatable=false, columnDefinition = "SMALLINT"),
      @JoinColumn(name = "assess_tst_id", insertable=false, updatable=false, columnDefinition = "INT"),
    })
    public AssessQstnChoice getAssessQstnChoice() {
        return this.assessQstnChoice;
    }