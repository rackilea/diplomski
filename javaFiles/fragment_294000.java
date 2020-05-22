public class CurrentDateServiceImpl implements CurrentDateService {
    public LocalDate getCurrentDate() {
        return LocalDate.now() ;

    }
}

public class CurrentDateServiceFormatImpl implements CurrentDateServiceFormat{
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    CurrentDateService service;

    public void myMethod(){
       return service.getCurrentDate().format(FORMATTER); 
    }

    public void setService(CurrentDateService service){
       this.service = service;
    }
}

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

  <bean id= "currentDateService" class ="xx.CurrentDateSerivceimpl" />
  <bean id= "CurrentDateServiceFormat" class ="xx.CurrentDateServiceFormatImpl">
     <property name="service" id-ref="currentDateService"/>
  </bean>
</beans>