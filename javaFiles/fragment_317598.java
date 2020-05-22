for(int i = 0; i < android.length(); i++){
            JSONObject c = android.getJSONObject(i);


            // Storing  JSON item in a Variable
            String infoView = c.getString(information);
            String dateView = c.getString(date);
            String whereView = c.getString(where);
            String PhotoView = c.getString(flag);


            // Adding value HashMap key => value

            HashMap<String, String> map = new HashMap<String, String>();

            map.put(information, infoView);
            map.put(date, dateView);
            map.put(whereView, where);
            map.put(PhotoView, flag);


            oslist.add(map);

            viewPager = (ViewPager) getActivity().findViewById(R.id.pager);
            adapter = new ViewPagerAdapter(getActivity(), oslist, where, date, information, flag);

            viewPager.setAdapter(adapter);


        }