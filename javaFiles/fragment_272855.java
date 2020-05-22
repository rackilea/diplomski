try{

            URL url=new URL("http://172.25.183.183:8080/JIRAservice/rest/runquery");
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            String projectKey=Home.savedid;
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("query"," { \"jql\": \"project=" + projectKey + "\", \"startAt\": 0, \"maxResults\": 100, \"fields\": [\"summary\",\"customfield_10006\", \"status\", \"description\"] }"));
            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(getQuery(params));
            writer.flush();
            writer.close();
            os.close();

            conn.connect();

            int respnse=conn.getResponseCode();
            String output="Request URl"+url;
            output+=System.getProperty("line.separator");
            output+=System.getProperty("line.separator")+"Response Code"+respnse;
            BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line= "";
            StringBuilder respop=new StringBuilder();
            while((line=br.readLine())!=null){
                respop.append(line);
            }
            br.close();
            output +=System.getProperty("line.separator")+"IssueList from API"+respop.toString();
            System.out.println("IssueList"+ output);
            String respfield=resp(respop.toString());
            System.out.println(" response"+ respfield);




        }catch(MalformedURLException ae){
            ae.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }