dataManager.getAdminCategories().mergeWith(dataManager.insertData(userId, userArray)
            .flatMap(new Func1<CategoryList, Observable<CategoryList>>() {
                @Override
                public Observable<CategoryList> call(CategoryList categoryList) {
                    // code to save data from service A to db

                    // call service B
                    return dataManager.getUserCategories(userId);
                }
            }))