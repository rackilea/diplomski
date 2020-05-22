Pattern PAIR = Pattern.compile("(?<=\\d)\\s(?=\\d)");

    double[][] result = PAIR.splitAsStream(stringProfile)
            .map(pair -> pair.split(","))
            .map(pair -> new double[] { FastMath.toRadians(Double.valueOf(pair[0])), FastMath.toRadians(Double.valueOf(pair[1])) })
            .toArray(i -> new double[i][]);