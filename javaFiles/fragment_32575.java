@repeat(formUser("places"), min = 1) { stayField =>
      <div id="groupLocationField">
        @select(formUser(stayField.name.toString + ".place"), options(Place.optionsTitle))
        @inputDate(formUser(stayField.name.toString + ".startDate"))
        @inputDate(formUser(stayField.name.toString + ".endDate"))
      </div>
    }