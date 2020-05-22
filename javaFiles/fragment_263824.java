private static List<ColDef<BauwerkOption, ?>> DEF = new ArrayList<>();
static {
    DEF.add(new ColDef<BauwerkOption, String>("A", BauwerkOption::getBauwerkstyp));
    DEF.add(new ColDef<BauwerkOption, String>("B", BauwerkOption::getBezeichnung).withSetValueAtFunction(BauwerkOption::setBauwerkstyp));
    DEF.add(new ColDef<BauwerkOption, String>("C", BauwerkOption::getNutzungsart));
    DEF.add(new ColDef<BauwerkOption, Double>("D", BauwerkOption::getDurchmesser));
}