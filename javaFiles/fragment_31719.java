List<MemberDependentBO> listOfMemberAndDep = (List<MemberDependentBO>)httpSession.getAttribute("insuredInfo");

if(listOfMemberAndDep == null){
    listOfMemberAndDep = new ArrayList<MemberDependentBO>();
}

MemberDependentBO memberdepinfo = new MemberDependentBO();
memberdepinfo.setFirstName(getMemberFirstName().getValue().toString());
memberdepinfo.setLastName(getMemberLastName().getValue().toString());
memberdepinfo.setMiddleName(getMemberMiddleName().getValue().toString());
memberdepinfo.setPassport(getMemberPassportNumber().getValue().toString();

listOfMemberAndDep.add(memberdepinfo);
httpSession.setAttribute("insuredInfo", listOfMemberAndDep);
System.out.println("List Size :"+listOfMemberAndDep.size());