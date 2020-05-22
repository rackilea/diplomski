public interface customSheetsI {
    default String getLogWorkbook() {
        return (String) getWorkbook();
    }

    YourReturnType getWorkbook();
}