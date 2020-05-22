if (counter.get() == 0) {
 sb.append("<tr><td><h4>Too many results. Please, refine your query.</h4></td></tr>" );
 } else if (counter.get() == 100) {
 sb.append("<tr><td><h4>"); // NOI18N
 sb.append(NbBundle.getMessage(OQLController.class, "OQL_NO_RESULTS_MSG")); // NOI18N
 sb.append("</h4></td></tr>" ); // NOI18N
 }