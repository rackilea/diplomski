import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CsvXlsxUpdater {

    private static final DateTimeFormatter DATE_TIME_FORMATTER_CSV = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private Path csvFilePath;
    private Path xlsxFilePath;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private Map<LocalDate, List<String>> csvContent = new TreeMap<LocalDate, List<String>>();
    private ZoneId zoneId = ZoneId.systemDefault();

    public CsvXlsxUpdater(String pathToCsvFile, String pathToXlsxFile) {
        csvFilePath = Paths.get(pathToCsvFile);
        xlsxFilePath = Paths.get(pathToXlsxFile);
    }

    /**
     * Reads the content of the csv file into the corresponding class variable,
     * which is a {@link TreeMap} that has a {@link LocalDate} as key and a 
     * {@link List<String>} as values.
     */
    private void readCsvContent() {
        List<String> csvLines;

        try {
            csvLines = Files.readAllLines(csvFilePath);

            for (int i = 1; i < csvLines.size(); i++) {
                String line = csvLines.get(i);
                String[] splitValues = line.split(",");

                if (splitValues.length > 1) {
                    List<String> lineValues = Arrays.asList(splitValues);
                    List<String> projects = getProjectValuesFrom(lineValues);
                    LocalDate localDate = LocalDate.parse(lineValues.get(0), DATE_TIME_FORMATTER_CSV);
                    if (csvContent.containsKey(localDate)) {
                        projects.forEach((String project) -> {
                            List<String> csvProjects = csvContent.get(localDate);
                            if (!csvProjects.contains(project)) {
                                csvProjects.add(project);
                            }
                        });
                    } else {
                        csvContent.put(localDate, projects);
                    }
                } else {
                    LocalDate localDate = LocalDate.parse(splitValues[0], DATE_TIME_FORMATTER_CSV);
                    csvContent.put(localDate, new ArrayList<String>());
                }
            }
        } catch (IOException e) {
            System.err.println("CANNOT FIND OR READ CSV FILE: " + e.getMessage());
            e.printStackTrace();
        } catch (UnsupportedOperationException e) {
            System.err.println("UNSUPPORTED OPERATION: " + e.getMessage());
            e.printStackTrace();
        }

    }

    /**
     * Gets the corresponding {@link LocalDate} from a given (and deprecated)
     * {@link Date}
     * 
     * @param date the deprecated {@link Date} object
     * @return the corresponding {@link LocalDate}
     */
    private LocalDate parseLocalDateFrom(Date date) {
        Instant instantDate = date.toInstant();
        return instantDate.atZone(zoneId).toLocalDate();
    }

    /**
     * Takes a list of read values from the csv file and returns a list containing
     * all the values of the given list <strong>except from the first
     * element</strong>, which is a {@link String} representation of a date and
     * should be treated differently in this context.
     * 
     * @param values the original list of {@link String}s
     * @return another list without the first element of the given list
     */
    private List<String> getProjectValuesFrom(List<String> values) {
        List<String> projectValues = new ArrayList<String>();

        for (int i = 1; i < values.size(); i++) {
            String value = values.get(i);
            if (!value.equals("")) {
                projectValues.add(value);
            }
        }

        return projectValues;
    }

    /**
     * Updates the workbook with the values read from the csv file
     */
    public void updateWorkbook() {
        readCsvContent();
        try {
            FileInputStream fis = new FileInputStream(xlsxFilePath.toAbsolutePath().toString());
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);

            // iterate over the rows
            Iterator<Row> rowIterator = sheet.rowIterator();

            while (rowIterator.hasNext()) {
                XSSFRow row = (XSSFRow) rowIterator.next();

                if (row.getRowNum() == 0) {
                    // skip this or set updated headers
                } else {
                    // check if the csvContent contains the value of cell(0)
                    LocalDate dateKey = parseLocalDateFrom(row.getCell(0).getDateCellValue()); 
                    if (csvContent.containsKey(dateKey)) {
                        // if yes, get list-value of the key
                        List<String> values = csvContent.get(dateKey);

                        // check if there are values
                        if (values != null) {
                            if (values.size() > 0) {
                                // if there are, then go checking the cell values
                                List<String> projectsInXlsx = new ArrayList<String>();
                                Iterator<Cell> cellIterator = row.cellIterator();
                                int lastColumnIndex = 1;

                                // go through all cells with a value except from the first one
                                while (cellIterator.hasNext()) {
                                    Cell cell = cellIterator.next();

                                    // skip the first column as it contains the date
                                    if (cell.getColumnIndex() != 0) {
                                        lastColumnIndex = cell.getColumnIndex();
                                        System.out.println("Accessing cell in column " + lastColumnIndex);
                                        // if there is a cell with a value
                                        if (cell.getStringCellValue() != null) {
                                            if (!cell.getStringCellValue().equals("")) {
                                                // check if the value in the cell is also in the csv values
                                                if (values.contains(cell.getStringCellValue())) {
                                                    projectsInXlsx.add(cell.getStringCellValue());
                                                    lastColumnIndex++;
                                                }
                                            }
                                        }
                                    }
                                }

                                // now go through the values of the csv file
                                int offset = 0; // cell column offset for more than one entry per date
                                for (String value : values) {
                                    if (!projectsInXlsx.contains(value)) {
                                        // create a cell after the last one with a value
                                        row.createCell(lastColumnIndex + offset).setCellValue(value);
                                        offset++;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            fis.close();

            FileOutputStream fileOutputStream = new FileOutputStream(xlsxFilePath.toAbsolutePath().toString());
            workbook.write(fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}