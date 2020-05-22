@ManyToOne(optional = false)
    @JoinTable(
        name = "Student_Pseudo", 
        joinColumns = @JoinColumn(name = "STU_CODE", nullable=false), 
        inverseJoinColumns = @JoinColumn(name="STU_CODE", nullable=false))
private Pseudo pseudo;