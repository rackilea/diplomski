if (toReduce.contains("*CUSIP Detail information will be available when this issue settles.")) {
        log.append("CUSIP Detail not available.For " + urls.get(i) + "\n");
    } else {
        buffer.delete(0, toReduce.indexOf("Cusip/ISIN"));
        buffer.delete(buffer.indexOf("Underwriters:"), buffer.length());

        String[] data = new String[13];

        data[0] = buffer.substring(0, buffer.indexOf("Instrument Type:"));
        data[1] = buffer.substring(buffer.indexOf("Instrument Type:"), buffer.indexOf("Call Type:"));
        data[2] = buffer.substring(buffer.indexOf("Call Type:"), buffer.indexOf("Issue Date:"));
        data[3] = buffer.substring(buffer.indexOf("Issue Date:"), buffer.indexOf("Issue Price:"));
        data[4] = buffer.substring(buffer.indexOf("Issue Price:"), buffer.indexOf("Amount Issued:"));
        data[5] = buffer.substring(buffer.indexOf("Amount Issued:"), buffer.indexOf("Lockout Period:"));
        data[6] = buffer.substring(buffer.indexOf("Lockout Period:"), buffer.indexOf("Currency"));
        data[7] = buffer.substring(buffer.indexOf("Currency"), buffer.indexOf("Denomination:"));
        data[8] = buffer.substring(buffer.indexOf("Denomination:"), buffer.indexOf("First Payment"));
        data[9] = buffer.substring(buffer.indexOf("First Payment"), buffer.indexOf("Maturity Date"));
        data[10] = buffer.substring(buffer.indexOf("Maturity Date"), buffer.indexOf("Original Coupon:"));
        data[11] = buffer.substring(buffer.indexOf("Original Coupon:"), buffer.indexOf("Current Coupon:"));
        data[12] = buffer.substring(buffer.indexOf("Current Coupon:"), buffer.length());

        for (String s : data) {
            writer.write(s);
            writer.write(",");
            writer.newLine();
        }
    }