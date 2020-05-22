@RequestMapping(value = "/eblnotif/exportMailId", method = RequestMethod.POST, produces = "application/json")
public @ResponseBody String exportMailIdCsv(@RequestBody Filters filters) throws IllegalAccessException,
        IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException {

    List<EblNotif> eblnotif_list = accountSservice.exportMailIdCsv(filters);

    String separator = ";";
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    StringBuilder sb = new StringBuilder();
    sb.append("formName;mode;language;sendingDate;gpart;email;mailId").append(System.lineSeparator());
    for (EblNotif eblNotif : eblnotif_list) {
        sb.append(eblNotif.getFormName()).append(separator);
        sb.append(eblNotif.getMode()).append(separator);
        sb.append(eblNotif.getLanguage()).append(separator);
        sb.append(dateFormat.format(eblNotif.getSendingDate())).append(separator);
        sb.append(eblNotif.getGpart()).append(separator);
        sb.append(eblNotif.getEmail()).append(separator);
        sb.append(eblNotif.getMailId()).append(separator);
        sb.append(System.lineSeparator());
    }
    return sb.toString();
}