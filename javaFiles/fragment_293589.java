public static ResponseBody callAPI(String host, String body, String path, String method, Map<String,String> headers){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

        requestSpecBuilder.addHeaders(headers);
        requestSpecBuilder.setBody(body);
        requestSpecBuilder.setBaseUri(host);

        RequestSpecification requetSpecification = requestSpecBuilder.build();
        requestSpecBuilder.setContentType(ContentType.JSON);
        Response rs = null;
        if(method.equals("DELETE")){
            rs  = RestAssured.given(requetSpecification).when().log().all().delete(path);
        }else if(method.equals("POST")){
            rs  = RestAssured.given(requetSpecification).when().log().all().post(path);
        }

        return rs.getBody();

    }