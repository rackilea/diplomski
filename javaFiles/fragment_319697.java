<form th:action="@{/destination}" th:object="${myThymeleafFormObject}">

public class ThymeleafForm {

    private String fleetFirstName;
    private String serviceFirstName;

    ...

}