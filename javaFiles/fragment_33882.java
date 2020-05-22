private static void merge(StringWriter out, BufferedReader ... in) throws IOException {
    CustomerReader[] customerReader = new CustomerReader[in.length];
    for (int i = 0; i < in.length; i++)
        customerReader[i] = new CustomerReader(in[i]);
    merge(out, customerReader);
}

private static void merge(StringWriter out, CustomerReader ... in) throws IOException {
    List<CustomerReader> min = new ArrayList<>(in.length);
    for (;;) {
        min.clear();
        for (CustomerReader reader : in)
            if (reader.hasData()) {
                int cmp = (min.isEmpty() ? 0 : reader.compareTo(min.get(0)));
                if (cmp < 0)
                    min.clear();
                if (cmp <= 0)
                    min.add(reader);
            }
        if (min.isEmpty())
            break; // all done
        // optional: Verify that lines that compared equal by ID are entirely equal
        out.write(min.get(0).getCustomerLine());
        out.write(System.lineSeparator());
        for (CustomerReader reader : min)
            reader.readNext();
    }
}

private static final class CustomerReader implements Comparable<CustomerReader> {
    private BufferedReader in;
    private String         customerLine;
    private int            customerId;
    CustomerReader(BufferedReader in) throws IOException {
        this.in = in;
        readNext();
    }
    void readNext() throws IOException {
        if ((this.customerLine = this.in.readLine()) == null)
            this.customerId = Integer.MAX_VALUE;
        else
            this.customerId = Integer.parseInt(this.customerLine.substring(0, this.customerLine.indexOf('|')));
    }
    boolean hasData() {
        return (this.customerLine != null);
    }
    String getCustomerLine() {
        return this.customerLine;
    }
    @Override
    public int compareTo(CustomerReader that) {
        // Order by customerId only. Inconsistent with equals()
        return Integer.compare(this.customerId, that.customerId);
    }
}