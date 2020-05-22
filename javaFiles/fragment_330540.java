public SetRows(Context currentContext,int image, String name, String id) {

        super();

        this.image = image;
        this.name = Html.fromHtml(currentContext.getResources().getString(R.string.colorcol)) + " COLOR: \n\t" + name;
        this.id = "MEANS: \n\t" +  id;
    }