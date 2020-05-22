StringBuffer param = new StringBuffer()
       param.append("http://localhost:1025/cgi-bin/sendsms?")
       param.append(URLEncoder.encode("username","UTF-8")).append("=").append(URLEncoder.encode("xxx","UTF-8"))
       param.append("&").append(URLEncoder.encode("password","UTF-8")).append("=").append(URLEncoder.encode("xxxx","UTF-8"))
       param.append("&").append(URLEncoder.encode("to","UTF-8")).append("=").append(URLEncoder.encode(numTel,"UTF-8"));

       param.append("&").append(URLEncoder.encode("coding","UTF-8")).append("=").append(URLEncoder.encode("2","UTF-8"))
       param.append("&").append(URLEncoder.encode("text","UTF-8")).append("=").append(URLEncoder.encode(text,"UTF-8"))
       param.append("&").append(URLEncoder.encode("priority","UTF-8")).append("=").append(URLEncoder.encode(""+priority,"UTF-8"))
       param.append("&").append(URLEncoder.encode("dlr-mask","UTF-8")).append("=").append(URLEncoder.encode("31","UTF-8"))
       param.append("&").append(URLEncoder.encode("dlr-url","UTF-8")).append("=").append(URLEncoder.encode(urlString,"UTF-8"))
       try{
           URL url = new URL(param.toString())
           System.out.println("INFO : Opening connection ")
           HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection()
           System.out.println("INFO : Connection openned")
           BufferedReader input = new BufferedReader( new InputStreamReader(urlconnection.getInputStream()))
           String inputLine

           while ((inputLine = input.readLine()) != null)
               aResult.append(inputLine)
           input.close()
       }catch(Exception e){
           e.printStackTrace()
           return false
       }

       System.out.println("response : "+aResult.toString())
       System.out.println("INFO : all sent disconnect.")