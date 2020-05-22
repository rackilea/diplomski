StringBuilder sb = New StringBuilder();
for(String id: idList)
{
   sb.append("'"+id+"',")
}
sb.deleteCharAt(sb.length() -1);
sb.toString();