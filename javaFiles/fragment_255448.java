given(restTemplate
        .exchange(eq("https://trackapi.nutritionix.com/v2/natural/nutrients"),
            ArgumentMatchers.eq(HttpMethod.POST),
            ArgumentMatchers.any(),
            ArgumentMatchers.<ParameterizedTypeReference<List<FoodNutritional>>>any()))
        .willReturn(
            new ResponseEntity<List<FoodNutritional>>(
                foodsNutritionalStabData(),
                HttpStatus.OK));