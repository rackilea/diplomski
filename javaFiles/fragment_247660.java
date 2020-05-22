<%

        Iterator it = el.getCenterHasStaffs().iterator();

        while (it.hasNext()) {

        CenterHasStaff elem = (CenterHasStaff) it.next();
        out.print(elem.getStaff().getNameWithinitials());

                             }


%>