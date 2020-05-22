public static boolean ReadCategoryFileTxt(Category category) {

    try {

        File file = new File(category.Name + ".txt");
        Scanner sc = new Scanner(file);
        StringBuilder JSONString = new StringBuilder;

        while (sc.hasNextLine()) 
            JSONString = JSONString.append(sc.nextLine());

        Gson gson = new Gson();
        Category _category = gson.fromJson(JSONString.toString().trim(), Category.class);

        category.Name = _category.Name;
        category.Questions = _category.Questions;

        //Debug.Println(gson.toJson(category, Category.class));

        sc.close();
    }
    catch (Exception e)
    {
        Debug.PrintException(e);
        return (false);
    }

    return (true);
}