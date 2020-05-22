<bean id="numberGuess" class="org.spring.samples.NumberGuess">
   <property name="randomNumber" value="#{ T(java.lang.Math).random() * 100.0 }"/>
   <!-- other properties -->
</bean>


<bean id="shapeGuess" class="org.spring.samples.ShapeGuess">
  <property name="initialShapeSeed" value="#{ numberGuess.randomNumber }"/>
   <!-- other properties -->
</bean>