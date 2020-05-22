// show Category name in text in the category field.
                    if(columnNames[i].equalsIgnoreCase("category")){
                        Object obj = rs.getObject(i+1);
                        if(obj != null && (obj instanceof Integer) )
                            row[i] = (String) categoryMap.get((Integer) obj);
                    }