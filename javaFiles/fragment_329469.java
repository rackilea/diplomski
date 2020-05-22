private List<Object[]> turls=new ArrayList<Object[]>(); //get the list of Object[] from HQL


for(Object[] r : turls)
                {
                    FilesInfo inf =(FilesInfo)r[0];
                    System.out.println(inf.getUrl());
                }