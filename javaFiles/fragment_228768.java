@OneToOne(mappedBy = "impactRadio", fetch = FetchType.EAGER)
@JoinColumn(name = "IA_ID")
private ImpactRadioAmendment amendments;

@OneToOne(mappedBy = "impactRadio", fetch = FetchType.EAGER)
@JoinColumn(name = "IA_ID")
private ImpactRadioExamination examinations;