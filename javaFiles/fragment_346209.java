if (!result.equals("employee ID doesnt match!!") || !result.equals("post variables are not set")) {
                JSONObject json = new JSONObject(result);

              int  MAX_ROWS = Integer.parseInt(json.getString("count"));
                System.out.println("rows:"+MAX_ROWS);
                String taskname[] = new String[MAX_ROWS];
                JSONArray tasks = json.getJSONArray("tasks");
                for (int task_id = 0; task_id < MAX_ROWS; task_id++) {
                    taskname[task_id] = tasks.getString(task_id);
                    System.out.println(tasks.getString(task_id));
                }

            }