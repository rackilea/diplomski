ArrayList<ListData> tempList = new ArrayList<>();
                        for(int i = 0; i<data.size();i++){
                                String name = data.get(i).getName();
                                Log.e("name: ", name);
                                String number = String.valueOf(i);
                                Log.e("number: ", number);
                                String uri = data.get(i).getUri();
                                Log.e("uri: ", uri);
                                ListData listData = new ListData();
                                listData.setName(name);
                                listData.setNumber(number);
                                listData.setUri(uri);
                                tempList.add(listData);
                            }
                        data.clear();
                        for(int i=0; i<tempList.size(); i++){
                                String name = tempList.get(i).getName();
                                Log.e("getName: ", name);
                                String number = String.valueOf(i);
                                Log.e("getNumber: ", number);
                                String uri = tempList.get(i).getUri();
                                Log.e("getUri: ", uri);
                                ListData listData = new ListData();
                                listData.setName(name);
                                listData.setNumber(number);
                                listData.setUri(uri);
                                data.add(listData);
                        }