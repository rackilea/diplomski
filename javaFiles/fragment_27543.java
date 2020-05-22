public class SheetPool {

    private List<Sheet> sheets;

    public List<Sheet> getSheets() {
        return sheets;
    }

    public Sheet getObject() {
        int index = ThreadLocalRandom.current().nextInt(sheets.size());
        return sheets.get(index);
    }

}