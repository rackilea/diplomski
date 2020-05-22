for (int i = 0; i < listOfFlags.get(increament).size(); i++) {
                HashMap<String, String> hm = new HashMap<String, String>();
                hm.put("flag", Integer.toString(listOfFlags.get(increament).get(i).get(0)));
                aList.add(hm);
            }

            SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.gridviewdata, from, to);
            gridview.setAdapter(simpleAdapter);
        }
    });