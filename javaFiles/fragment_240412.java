public String exportToExl() {

        ExportToExcel expExlBean = new ExportToExcel();

        List<String> columnNames = new ArrayList<String>();
        columnNames.add("Agenda ID");
        columnNames.add("Matter");
        columnNames.add("Item");
        columnNames.add("OrderNo");
        columnNames.add("AccessPrivilegeString");

        columnNames.add("DocumentNameDisplay");
        columnNames.add("DocumentFolderPath");

        List<String> columnType = new ArrayList<String>();
        columnType.add(FrameWorkConstants.DO_NOT_FORMAT);
        columnType.add(FrameWorkConstants.DO_NOT_FORMAT);
        columnType.add(FrameWorkConstants.DO_NOT_FORMAT);
        columnType.add(FrameWorkConstants.DO_NOT_FORMAT);
        columnType.add(FrameWorkConstants.DO_NOT_FORMAT);
        columnType.add(FrameWorkConstants.DO_NOT_FORMAT);
        columnType.add(FrameWorkConstants.DO_NOT_FORMAT);

        String companyFolderPath = new AgendaIMPL()
                .getCompanyFolderPath(meetingID);
        if (agendaList != null) {
            for (int i = 0; i < agendaList.size(); i++) {
                agendaList.get(i).setDocumentFolderPath(companyFolderPath);
            }
        }
        List expList = agendaList;

        if (expList == null || expList.isEmpty()) {
            ResourceBundle rb = ResourceBundle
                    .getBundle("resources.error1");
            if (rb != null) {
                Utils.addMessage(rb.getString("34").trim(),
                        FacesMessage.SEVERITY_ERROR);
                return null;
            }
        }

        String strVOName = "com.ultimatix.boardAdmin.vo.AgendaVO";

        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) fc
                .getExternalContext().getResponse();

        String flagStart = FrameWorkConstants.SINGLE;
        expExlBean.exportToExcel(columnNames, columnType, response,
                expList, strVOName, flagStart);

        fc.responseComplete();
    return null;
}