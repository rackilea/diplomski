public String[] buildColList() {
        //Parse the qty col names string, which is a comma separated string
        String qtyString = getQtyString();
        List<String> qtyCols = Arrays.asList(qtyString.split("\\s*,\\s*"));

        String colString = StringUtils.join(qtyCols.toArray(), "\"" +  ", " + "\"");

        String[] fullColString = new String[]{getString1(), getString2(), colString, getString4};
        return fullColString;
}