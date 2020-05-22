import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oracle.jrockit.jfr.parser.ParseException;

public class Report {

    public static void main(String[] args) {
        new Report();
    }

    public Report() {
        try {
            EmployeeManager empManager = new EmployeeManager();
            TimeClockManager timeClockManager = new TimeClockManager();

            for (Employee emp : empManager.getEmployees()) {

                System.out.println("[" + emp.getId() + "] " + emp.getName());
                for (TimeClockEntry tce : timeClockManager.getByEmployee(emp)) {
                    System.out.println("    "
                            + CLOCK_DATE_TIME_FORMAT.format(tce.getInTime())
                            + " to "
                            + CLOCK_DATE_TIME_FORMAT.format(tce.getOutTime()));
                }

            }

        } catch (IOException | ParseException exp) {
            exp.printStackTrace();
        }
    }

    public class EmployeeManager {

        private Map<Integer, Employee> employees;

        public EmployeeManager() throws IOException {
            employees = new HashMap<>(25);
            try (BufferedReader br = new BufferedReader(new FileReader(new File("NewEmployee8.txt")))) {
                String text = null;
                while ((text = br.readLine()) != null) {
                    if (!text.trim().isEmpty()) {
                        Employee emp = new Employee(text);
                        employees.put(emp.getId(), emp);
                    }
                }
            }
        }

        public List<Employee> getEmployees() {
            return Collections.unmodifiableList(new ArrayList<Employee>(employees.values()));
        }

        public Employee getEmployee(int id) {
            return employees.get(id);
        }

    }

    public class TimeClockManager {

        private Map<Integer, List<TimeClockEntry>> timeClockEntries;

        public TimeClockManager() throws IOException, ParseException {
            timeClockEntries = new HashMap<>(25);
            try (BufferedReader br = new BufferedReader(new FileReader(new File("TimeClock1.txt")))) {
                String text = null;
                TimeClockEntry entry = null;
                int line = 0;
                while ((text = br.readLine()) != null) {

                    if (!text.trim().isEmpty()) {
                        if (line % 2 == 0) {
                            entry = new TimeClockEntry(text);
                        } else {
                            entry.setClockTimeFrom(text);

                            List<TimeClockEntry> empEntries = timeClockEntries.get(entry.getEmployeeID());
                            if (empEntries == null) {
                                empEntries = new ArrayList<>(25);
                                timeClockEntries.put(entry.getEmployeeID(), empEntries);
                            }

                            empEntries.add(entry);

                        }
                        line++;
                    }

                }
            }
        }

        public List<TimeClockEntry> getByEmployee(Employee emp) {

            List<TimeClockEntry> list = timeClockEntries.get(emp.getId());

            list = list == null ? new ArrayList<>() : list;

            return Collections.unmodifiableList(list);

        }

    }

    public class Employee {

        private final int id;
        private final String name;

        public Employee(String text) {
            System.out.println("[" + text + "]");
            for (char c : text.toCharArray()) {
                System.out.print((int) c + ",");
            }
            System.out.println("");
            String[] parts = text.split("\\s+");
            id = Integer.parseInt(parts[2]);
            name = parts[0] + " " + parts[1];
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

    }

    public static final SimpleDateFormat CLOCK_DATE_TIME_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    public static final SimpleDateFormat CLOCK_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public class TimeClockEntry {

        private Date inTime;
        private Date outTime;
        private int employeeID;

        public TimeClockEntry(String text) throws ParseException {
            System.out.println("[" + text + "]");
            for (char c : text.toCharArray()) {
                System.out.print((int) c + ",");
            }
            System.out.println("");
            String parts[] = text.split("\\s+");
            employeeID = Integer.parseInt(parts[2]);
            setClockTimeFrom(text);
        }

        public void setClockTimeFrom(String text) throws ParseException {
            String parts[] = text.split("\\s+");
            if ("in".equalsIgnoreCase(parts[3])) {
                inTime = CLOCK_DATE_TIME_FORMAT.parse(parts[0] + " " + parts[1]);
            } else if ("out".equalsIgnoreCase(parts[3])) {
                outTime = CLOCK_DATE_TIME_FORMAT.parse(parts[0] + " " + parts[1]);
            }
        }

        public int getEmployeeID() {
            return employeeID;
        }

        public Date getInTime() {
            return inTime;
        }

        public Date getOutTime() {
            return outTime;
        }

    }

}