The Action class:

public class SomeAction extends DispatchAction {
 public ActionForward someRequest(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)
            throws Exception {
  SomeForm someForm = ( SomeForm) form;
  List<SomeDTO> someList = populateDto();
  someForm.setSomeList(someList);
  return mapping.findForward("someAction");

}
The Form class:

public class SomeForm extends ActionForm{

   List<SomeDTO> someList;
   //getter and setters for someList
}

StrutsConfig:

<form-beans>
    <form-bean name="someForm" type="my.forms.SomeForm" />
</form-beans>

<action path="/someRequest"
            type="my.actions.SomeAction"
            name="someForm" scope="request" >
<forward name="someAction" path="goesSomeWhere" />

</action>

View:

<c:forEach items="${someForm.someList}" var="someThing" varStatus="someCounter">
    <c:out value="${someThing.foo}" /> <!-- assuming foo is a member in SomeThing DTO -->
</c:forEach>