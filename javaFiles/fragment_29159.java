package com.example;

    import com.google.gson.annotations.Expose;
    import com.google.gson.annotations.SerializedName;

    public class Example {

     @SerializedName("result")
     @Expose
     private Result result;

     public Result getResult() {
      return result;
     }

     public void setResult(Result result) {
      this.result = result;
     }

     public class Result {

      @SerializedName("category")
      @Expose
      private List < Category > category = null;

      public List < Category > getCategory() {
       return category;
      }

      public void setCategory(List < Category > category) {
       this.category = category;
      }

     }
     public class Category {

      @SerializedName("id")
      @Expose
      private String id;
      @SerializedName("name")
      @Expose
      private String name;
      @SerializedName("slug")
      @Expose
      private String slug;
      @SerializedName("image")
      @Expose
      private String image;
      @SerializedName("sub-categories")
      @Expose
      private List < SubCategory > subCategories = null;

      public String getId() {
       return id;
      }

      public void setId(String id) {
       this.id = id;
      }

      public String getName() {
       return name;
      }

      public void setName(String name) {
       this.name = name;
      }

      public String getSlug() {
       return slug;
      }

      public void setSlug(String slug) {
       this.slug = slug;
      }

      public String getImage() {
       return image;
      }

      public void setImage(String image) {
       this.image = image;
      }

      public List < SubCategory > getSubCategories() {
       return subCategories;
      }

      public void setSubCategories(List < SubCategory > subCategories) {
       this.subCategories = subCategories;
      }
    }
      public class SubCategory_ {

       @SerializedName("id")
       @Expose
       private String id;
       @SerializedName("name")
       @Expose
       private String name;
       @SerializedName("slug")
       @Expose
       private String slug;
       @SerializedName("image")
       @Expose
       private String image;
       @SerializedName("sub-categories")
       @Expose
       private List < Object > subCategories = null;

       public String getId() {
        return id;
       }

       public void setId(String id) {
        this.id = id;
       }

       public String getName() {
        return name;
       }

       public void setName(String name) {
        this.name = name;
       }

       public String getSlug() {
        return slug;
       }

       public void setSlug(String slug) {
        this.slug = slug;
       }

       public String getImage() {
        return image;
       }

       public void setImage(String image) {
        this.image = image;
       }

       public List < Object > getSubCategories() {
        return subCategories;
       }

       public void setSubCategories(List < Object > subCategories) {
        this.subCategories = subCategories;
       }

      }
}