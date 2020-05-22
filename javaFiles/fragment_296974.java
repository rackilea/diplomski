@Column(name="pay_by_quarter")
@Type(type = "packageofclass.IntArrayUserType")
private Integer[] payByQuarter;

@Column(name="schedule")
@Type(type = "packageofclass.StringMultidimensionalArrayType")
private String[][] schedule;