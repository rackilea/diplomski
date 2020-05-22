<%

    ArrayList<HospitalDTO> list=(ArrayList<HospitalDTO>)request.getAttribute("arrayList");
    for(int i = 0; i < list.size(); i++) {
        HospitalDTO hsp = list.get(i);
        long no=hsp.getNumber();
        //session.setAttribute("contactNumber",no);
        String name=hsp.getName();
        Date nextDD=hsp.getNextDD();
        Date lastDD=hsp.getLastDD();

        out.println("<tr><td><input type='radio' value='" + i + "'></td><td class='text-center' >"+no+"</td><td class='text-center'>"+name+"</td><td class='text-center'>" + lastDD + "</td><td class='text-center'>" + nextDD + "</td></tr>");
    }

%>