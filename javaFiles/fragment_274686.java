StringBuffer strBuf = new StringBuffer();

Iterator iter = textMap.entrySet().iterator();

while (iter.hasNext()) {

    Map.Entry entry = (Map.Entry) iter.next();

    String inputName = (String) entry.getKey();

    String inputValue = (String) entry.getValue();

    if (inputValue == null) {

        continue;

    }

    strBuf.append("\r\n").append("--").append(BOUNDARY)

            .append("\r\n");

    strBuf.append("Content-Disposition: form-data; name=\""

            + inputName + "\"\r\n\r\n");

    strBuf.append(inputValue);

    logger.info(inputName + "," + inputValue);

}

out.write(strBuf.toString().getBytes());