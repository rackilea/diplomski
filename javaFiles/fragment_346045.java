String str = "[{" +
            "          id=1," +
            "          employee_name=\"Tiger Nixon\"," +
            "          employee_salary=320800," +
            "          employee_age=61," +
            "          profile_image=\"khkjh\"" +
            "       }," +
            "       {" +
            "          id=2," +
            "          employee_name=\"Garrett Winters\"," +
            "          employee_salary=170750," +
            "          employee_age=63," +
            "          profile_image=\"\"" +
            "       }," +
            "       {" +
            "          id=3," +
            "          employee_name=\"Ashton Cox\"," +
            "          employee_salary=86000," +
            "          employee_age=66," +
            "          profile_image=\"\"" +
            "       }," +
            "       {" +
            "          id=4," +
            "          employee_name=\"Cedric Kelly\"," +
            "          employee_salary=433060," +
            "          employee_age=22," +
            "          profile_image=\"\"" +
            "       }" +
            "      ]";


         try{

            Gson gson = new Gson();
            ArrayList<Employee> list = gson.fromJson(str, ArrayList.class);

            String csv = CDL.toString(new JSONArray(list));

        }catch (Exception e){
            e.printStackTrace();
        }