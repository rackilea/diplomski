Map m=request.getParameterMap();
Set<String> keys = m.keySet();
ArrayList<String[]> valuesArr = new ArrayList<>(m.values());

out.print("<h1> Your Input Based on MapParamters</h1><br><br>");

int i = 0;
for (int j = 0; j < keys.size(); j++) {
    for (String key : keys) {
        for (String value : Arrays.copyOfRange(valuesArr.get(i), j, valuesArr.get(i).length)) {
            out.println(key + " : " + value + " ");
            i++;
            break;
        }
    }
    i=0;
    out.println("<br/>")
}