StringBuilder sb = new StringBuilder(128);
sb.append("update newtable set ");
for(int g=0;g<valAry.size();g++){

    sb.append("val1 =").append(valAry.get(g)).append(", min_val1 = IF (min_val1 <").append(valAry.get(g)).append(", min_val1 , ").append(valAry.get(g)).append(") , max_val1 = IF (max_val1 > ").append(valAry.get(g)).append(", max_val1 , ").append(valAry.get(g)).append("),");

}

sb.append("time_stamp = '").append(time_stamp).append("' where id = 1");