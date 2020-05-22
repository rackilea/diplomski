StringBuilder sb = new StringBuilder();

sb.append("FROM phone WHERE 1=1 ");


if (var1) {
    sb.append(" AND var1 = :var1");
}

if (var2) {
    sb.append(" AND var2 = :var2 ");
}

sb.toString();