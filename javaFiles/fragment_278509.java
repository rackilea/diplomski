package com.simpleproject;

import static org.assertj.core.api.Assertions.assertThat; 

public class Test {   

    @Test
    public void shouldTestMyClass() {
       // Given
       int givenNum = 3;

       // When
       MyApp myApp = new MyApp(givenNum);
       myApp.updateNumPlusTwo();

       // Then (use AssertJ library for example)
       assertThat(myApp.getUpdatedNum()).isEqualTo(5);
    }

}