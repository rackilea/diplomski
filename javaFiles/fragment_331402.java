List<MyEntity> myList = new ArrayList<>();

    myList = given().
            contentType(ContentType.JSON).
    when().
            get(getURL).
    then().
            extract().
            body().
            jsonPath().
            getList(".", MyEntity.class);