@MockBean
private BrandService brandService;

...
// if you want to test brandNames.contains(brand.getName())
Mockito.when(brandService.findAllBrandNames())
      .thenReturn(Arrays.asList("brand name"))
// now just send brand.setName("brand name"),it should test what's inside if block