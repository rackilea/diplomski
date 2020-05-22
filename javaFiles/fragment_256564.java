public class ProcessCsv {
    private File fileName;//getter + setter
    private String content;// getter + setter
    public String execute(){
        content = parseCsv(fileName);
        return SUCCESS;
    }
}