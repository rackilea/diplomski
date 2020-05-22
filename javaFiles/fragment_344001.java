/**
 * Creates a new XLSX -> CSV converter
 *
 * @param pkg        The XLSX package to process
 * @param output     The PrintStream to output the CSV to
 * @param minColumns The minimum number of columns to output, or -1 for no minimum
 */
public XLSX2CSV(OPCPackage pkg, PrintStream output, int minColumns) {