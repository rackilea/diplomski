<column forEach="${e.list}" label="${each}" >
  <window>
    <include src="index_1.zul" columnName="${each}" />      
    <textbox value="${each}"/>
  </window>
</column>