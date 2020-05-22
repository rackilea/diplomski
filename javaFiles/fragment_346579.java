new TextFilteredPropertyColumn<FilterPage.Entity, FilterPage.Entity, FilterPage.Entity>(Model.of("Finish Date"), dataProvider.getFilterState(), "finish") {

            private static final long serialVersionUID = 1L;

            @Override
            public Component getFilter(String componentId, FilterForm<?> form) {
                @SuppressWarnings({ "unchecked", "rawtypes" })
                TextFilter<Date> filter = new TextFilter(componentId, getFilterModel(form), form);
                filter.getFilter().add(new DatePicker());
                return filter;
            }

}