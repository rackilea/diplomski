public String[] parseTransfer(String cubacelMessage) {

        String[] data = new String[2];

        Pattern pattern = Pattern.compile("Usted ha recibido (\\d+\\.\\d+) CUC del numero (\\d+).*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(cubacelMessage);

        matcher.find();

        data[1] = matcher.group(1);
        data[2] = matcher.group(2);

        return data;
    }