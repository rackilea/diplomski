String deleteQids = "qid<> ";
StringBuilder sb = new StringBuilder(128);
for (int i = 0; i < 10; i++) {
    if (i > 0) {
        sb.append(" And ");
    }
    sb.append(deleteQids).append(i);

}
System.out.println(sb.toString());