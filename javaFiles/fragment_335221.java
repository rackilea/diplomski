Map<String,String> toView = new LinkedHashMap<String,String>();
..
..
toView.put(d.getDepartmentId()+"dept",d.getDepartmentName());
toView.put(i.getInstituteId()+"inst",i.getInstituteName());
toView.put(t.getTeacherId()+"teach",t.getTeacherTitle() + t.getTeacherName() + t.getTeacherSurname());