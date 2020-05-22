//Method to convert "Situation attribute type from String to Nominal"
private Instances StringToNominal(Instances dataset, String columnName) throws Exception {
        StringToNominal stringtoNominal = new StringToNominal();
         String[] options = new String[2];
            options[0] = "-R";
            options[1] = Integer.toString(dataset.classIndex()+2);  //this changes the Situation Type from String Into Nominal
            stringtoNominal.setOptions(options);
        stringtoNominal.setInputFormat(dataset);
        dataset = Filter.useFilter(dataset, stringtoNominal); 

    return dataset;
}