public class ProcessListTable {

  private String GetProcessListData() {
    Process p;
    Runtime runTime;
    String process = null;
    try {
        System.out.println("Processes Reading is started...");

        //Get Runtime environment of System
        runTime = Runtime.getRuntime();

        //Execute command thru Runtime
        // use appropriate command for linux "ps"
        p = runTime.exec("tasklist /FO CSV /nh");

        //Create Inputstream for Read Processes
        InputStream inputStream = p.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


        ArrayList<String> taskEntries = new ArrayList();
        String line = bufferedReader.readLine();
        while (line != null) {
            taskEntries.add(line);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();

        MyTableModel myTableModel = new MyTableModel();
        myTableModel.update(taskEntries);
        JTable table = new JTable(myTableModel);
        JFrame frame = new JFrame("TaskList");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setVisible(true);


        System.out.println("Processes are read.");
    } catch (IOException e) {
        System.out.println("Exception arise during the read Processes");
        e.printStackTrace();
    }
    return process;
}

 public class MyTableModel extends AbstractTableModel {

    String[] columnName = new String[]{"Image Name", "PID", "Session Name", "Session#", "Mem Usage"};
    String[][] valueA;

    public void update(ArrayList<String> taskEntries) {
        valueA = new String[taskEntries.size()][columnName.length];
        int size = taskEntries.size();
        for (int i = 0; i < size; i++) {
            String entry = taskEntries.get(i);
            String[] splitValues = entry.split(",");
            for (int j = 0; j < splitValues.length; j++) {
                String v = splitValues[j];
                v = v.replaceAll("\"", "");
                // mem contains "," so added mem usage at the end
                if (j >= 5) {
                    valueA[i][4] = valueA[i][4] + v;
                } else {
                    valueA[i][j] = v;
                }
            }
        }
    }

    @Override
    public int getRowCount() {
        return valueA.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return valueA[rowIndex][columnIndex];
    }
 }

 public static void main(String[] args) {
    ProcessListTable gpl = new ProcessListTable();
    gpl.GetProcessListData();
 }
}