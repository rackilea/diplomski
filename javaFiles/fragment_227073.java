@RequestMapping(value = "/editCitizen", method = RequestMethod.GET)
  public String editCitizen(@ModelAttribute("citizen") Citizen citizen, Model model) {
    // set attributes of citizen
    citizen.genderId = "M";
    citizen.weight = 180;
    // etc.

    // set other model attributes like lists for <form:select>s
    model.addAttribute("genderList", <list of genders>);
    return "path.to.my.jsp";
  }

<form:form id="citizenRegistration" name ="citizenRegistration" method="POST" commandName="citizen" action="citizen_registration.htm">
  <form:select path="genderId" items="${genderList}" itemLabel="genderDesc" itemValue="genderId"></form:select>
  <form:input path="weight" id="weight" title="Enter Weight"/>
</form:form>