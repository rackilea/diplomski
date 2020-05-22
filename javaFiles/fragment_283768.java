@ModelAttribute("memberrequest")
public  MemberRequest getMemberRequest(HttpSession session) {
MemberRequest mr = new MemberRequest();
  mr.setWelfare((String)session.getAttribute("welfare"));
    mr.setSchool((String)session.getAttribute("school"));
    mr.setTitle((String)session.getAttribute("title"));
    mr.setDistrict((String)session.getAttribute("district"));
    mr.setName((String)session.getAttribute("name"));
    mr.setFile((String)session.getAttribute("file"));
    mr.setQueue((String)session.getAttribute("queue"));
    mr.setRequestor(getUser());
    mr.setSchool_id((String)session.getAttribute("school_id"));
    mr.setBorough_id((String)session.getAttribute("borough_id"));
    mr.setRetiree((String)session.getAttribute("retiree"));
return mr;

}