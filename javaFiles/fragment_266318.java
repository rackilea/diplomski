ArrayAdapter<String> adapter = new ArrayAdapter<String>(RealestateActivity.this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapter.add("Select a Buseness...");                
        for (int i = 0; i < myUsers.length(); ++i)
        {
            adapter.add(myUsers.getString(i));
            adapter.add(myUsers.getJSONObject(i).getString("BusName"));
        }

            userSpinner.setAdapter(adapter); // I get an error here if I wrap these two lines in /*...*/ the whole thing loads as expected but the spinner is empty
            userSpinner.setOnItemSelectedListener(new MyOnItemSelectedListener());

        }
        catch (Exception e) 
        {       
            e.printStackTrace();
            displayExceptionMessage(e.getMessage());
        }