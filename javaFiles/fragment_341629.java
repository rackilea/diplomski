class Product {  
    static DEFAULT_IMAGE = "default.jpg"
    String name  
    Float basePrice  
    Category category  
    String image = DEFAULT_IMAGE

    static constraints = {
        name(size:3..25, blank:false)
        basePrice(scale:2, nullable:false)
        category(inList:Category.list(), nullable:false)
        image(blank:false)
    }
}

productInstance.image = getProductPicturePath() ?: Product.DEFAULT_IMAGE