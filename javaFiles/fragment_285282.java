for(String[] arr : sarray) 
                {
                  ContentTable data=new ContentTable();

                  for(String s : arr)   
                  {
                         data.setId(Integer.parseInt(s));
                         data.setSubid(Integer.parseInt(s));
                         data.setChpid(Integer.parseInt(s));
                         data.setSec_name(s);
                         data.setContent(s);
                  }
                  newData.add(data);
                }