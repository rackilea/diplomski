<%

    ArrayList<HospitalDTO> list=(ArrayList<HospitalDTO>)request.getAttribute("arrayList");
    for(int i = 0; i < list.size(); i++) {
        HospitalDTO hsp = list.get(i);
        long no=hsp.getNumber();
        //session.setAttribute("contactNumber",no);
        String name=hsp.getName();
        Date nextDD=hsp.getNextDD();
        Date lastDD=hsp.getLastDD();
        String rowId = "row_" + i;

        out.println("<tr id='" + rowId + "'><td class='text-center' >"+no+"</td><td class='text-center'>"+name+"</td><td class='text-center'>"+lastDD+

                "</td><td class='text-center'>"+nextDD+"</td><td class='text-center'><input type='submit' class='btn btn-info' value='Notify Donor'></td></tr>");
    }

%>