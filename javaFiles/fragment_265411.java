int count = 0;
for(String res : results) 
{
    log.info(res);
    resultHashMap.put("dataObject-"+count, res);
    count++;
}