//Get input presentation bean, using your desired id
PresentationBean presentationBean = AddAvailableDAO2.getPresentation("123");
//Get input lecturer bean, using your desired id
LecturerBean lecturerBean = AddAvailableDAO2.getLecturer("456");
//Add availability
AddAvailableDAO2.addavailable2(presentationBean, lecturerBean);
...