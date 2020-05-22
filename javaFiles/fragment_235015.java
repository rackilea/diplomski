// generate some dymmy data
Collection<Wrapper> wrappers = new HashSet<>();
for(int i=1000; i<=2000; i+=150) {
   wrappers.add(new Wrapper(i, 
           "Rand"+ThreadLocalRandom.current().nextInt(5000, 6000)) );
}

ListDataProvider<Wrapper> dpWrappers = new ListDataProvider<>(wrappers);
// now function returns the name of the wrapper to sort as sort argument
dpWrappers.setSortOrder(wrapper -> {return wrapper.getName();}, 
                            SortDirection.DESCENDING);

ComboBox<Wrapper> comboWrappers = new ComboBox<>();
comboWrappers.setDataProvider(dpWrappers);
// remember to set this to have the name of wrapper in combo vaptions
// instead of the value of  Wrapper.toString();
comboWrappers.setItemCaptionGenerator( item -> {return item.getName();});