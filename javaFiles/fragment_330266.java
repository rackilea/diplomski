public class PrnToCsv {

    private static final String DILIM_PRN = " ";
    private static final String DILIM_CSV = ",";
    private static final Pattern PRN_SPLITTER = Pattern.compile(DILIM_PRN);

    public static void main(String[] args) throws URISyntaxException, IOException {
        List<String> inputLines = Files.readAllLines(new File("C://Temp//csv/input.prn").toPath());
        List<String[]> inputValuesInLines = inputLines.stream().map(l -> PRN_SPLITTER.split(l)).collect(Collectors.toList());

        try (BufferedWriter bw = Files.newBufferedWriter(new File("C://Temp//csv//output.csv").toPath())) {
            // header
            bw.append("POL1").append(DILIM_CSV).append("POL1_Time").append(DILIM_CSV).append("OLV1").append(DILIM_CSV).append("OLV1_Time").append(DILIM_CSV);
            bw.append("POL2").append(DILIM_CSV).append("POL2_Time").append(DILIM_CSV).append("OLV2").append(DILIM_CSV).append("OLV2_Time");
            bw.newLine();

            // data
            for (int i = 0; i + 3 < inputValuesInLines.size(); i = i + 4) {
                String[] firstValues = inputValuesInLines.get(i);
                bw.append(getId(firstValues)).append(DILIM_CSV).append(getDateTime(firstValues)).append(DILIM_CSV);
                String[] secondValues = inputValuesInLines.get(i + 1);
                bw.append(getId(secondValues)).append(DILIM_CSV).append(getDateTime(secondValues)).append(DILIM_CSV);
                String[] thirdValues = inputValuesInLines.get(i + 2);
                bw.append(getId(thirdValues)).append(DILIM_CSV).append(getDateTime(thirdValues)).append(DILIM_CSV);
                String[] fourthValues = inputValuesInLines.get(i + 3);
                bw.append(getId(fourthValues)).append(DILIM_CSV).append(getDateTime(fourthValues));
                bw.newLine();
            }
        }
    }

    public static String getId(String[] values) {
        return values[1];
    }

    public static String getDateTime(String[] values) {
        return values[2] + " " + values[3];
    }

}