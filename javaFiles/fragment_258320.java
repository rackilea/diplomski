@Valid
private Maintain maintain;

@Valid
private Demand demand;

private List<ReplacedPart> replacedPartList;

public MaintainFormDto(Maintain maintain, Demand demand, List<ReplacedPart> replacedPartList) {
    this.maintain = maintain;
    this.demand = demand;
    this.replacedPartList = replacedPartList;
}
//GETTER and SETTERS