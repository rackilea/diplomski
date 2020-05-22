private AjaxFallbackDefaultDataTable table() {
      List<AbstractColumn> columns = new ArrayList<>();
      columns.add(new PropertyColumn(Model.of("Login"), "login", "login"));
      columns.add(new PropertyColumn(Model.of("First Name"), "firstName", "firstName"));
      columns.add(new PropertyColumn(Model.of("Last Name"), "lastName", "lastName"));
      AjaxFallbackDefaultDataTable dt = new AjaxFallbackDefaultDataTable("table", columns, new UserProvider(), 50);
      dt.setOutputMarkupPlaceholderTag(true);
      return dt;
   }