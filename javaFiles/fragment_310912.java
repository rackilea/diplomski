query.addSnapshotListener { querySnapshot, firebaseFirestoreException ->
    if (firebaseFirestoreException != null) {
        if (!emitter.isDisposed) {
            TODO("implement new exception logic")
        }
    } else {
        val categories = HashMap<String, Category>()
        for (document in querySnapshot.getDocuments()) {
            categories.put(document.getId(), document.toObject(Category::class.java))
        }
        val categoriesEntity = CategoriesEntity()
        categoriesEntity.setCategories(categories)
    }
}