@RequestMapping(value= "/addCategory", method= RequestMethod.POST)
    public String addCategory(@ModelAttribute("addCategoryObject") Category category){

    List<CategoryKey> categoryKey = category.getKeySet();


        for(int i = 0; categoryKey.size() >i;i++){
       CategoryKey categoryKeys = categoryKey.get(i);

        categoryKeys.setCategory(category);

        List<CategoryKey> categoryKeyList = new ArrayList<CategoryKey>();
        categoryKeyList.add(categoryKeys);
        category.setKeySet(categoryKeyList);

        categoryService.create(category);
        }

        return "addCategory";



         }