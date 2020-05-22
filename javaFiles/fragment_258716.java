<%
ObsDao dao = new ObsDao();
ObsDao otherdao = new ObsDao();
otherdao.setCompanyName("My company")
List<ObsBean> ComNotify = dao.getComNotify(otherdao);
for (ObsBean UserNotifi : ComNotify) {
.........
.........
}
%>