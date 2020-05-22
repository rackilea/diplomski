List<CategoryProjection> list = categoryRepository.findByCategory();

list.forEach(c -> {
      System.out.println(c.getLev1() + " - " + c.getLev2());
});
// loop i
for (int i = 0; i < list.size(); i++) {
   System.out.println(list.get(i).getLev1() + " - " + list.get(i).getLev2());         
}