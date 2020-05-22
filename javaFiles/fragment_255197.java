for (int i = 1; i < lines.size(); i++) {

        String[] values = lines.get(i).split(delimiter);

        StringBuilder cols = new StringBuilder();
        StringBuilder vals = new StringBuilder();

        for (int j = 0; j < columnNames.length; j++) {
            cols.append(columnNames[j]);
            vals.append("'").append(values[j]).append("'");

            if (j != columnNames.length - 1) {
                cols.append(",");
                vals.append(",");
            }
        }

        statements.add(String.format(template, cols.toString(), vals.toString()));
    }