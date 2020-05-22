public interface ReferenceController {

    public Map<String, ReferenceElement> searchElements(String searchField, List<String> searchItems, SystemStage systemStage) throws Exception;

    public String getStateMapping(String value);

    public Boolean isAvailable(SystemStage systemStage) throws Exception;
}