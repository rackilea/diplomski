public static void main(String[] args) throws JDOMException, IOException {
    Product product = null;

    product = new Product();
    product.categorie = "cat1";
    product.code = "code1";
    product.naamartikel = "naam1";
    product.beschrijvingartikel = "beschrijving1";
    product.prijz = 100d;
    product.imgurl = "http://localhost/img1.png";
    product.imgurl2 = "http://localhost/img2.png";
    product.imgurl3 = "http://localhost/img3.png";
    product.imgurl4 = "http://localhost/img5.png";
    product.imgurl5 = "http://localhost/img5.png";
    Writer(product);

    product = new Product();
    product.categorie = "cat2";
    product.code = "code2";
    product.naamartikel = "naam2";
    product.beschrijvingartikel = "beschrijving2";
    product.prijz = 200d;
    product.imgurl = "http://localhost/img21.png";
    product.imgurl2 = "http://localhost/img22.png";
    product.imgurl3 = "http://localhost/img23.png";
    product.imgurl4 = "http://localhost/img25.png";
    product.imgurl5 = "http://localhost/img25.png";
    Writer(product);

    product = new Product();
    product.categorie = "cat3";
    product.code = "code3";
    product.naamartikel = "naam3";
    product.beschrijvingartikel = "beschrijving3";
    product.prijz = 300d;
    product.imgurl = "http://localhost/img31.png";
    product.imgurl2 = "http://localhost/img32.png";
    product.imgurl3 = "http://localhost/img33.png";
    product.imgurl4 = "http://localhost/img35.png";
    product.imgurl5 = "http://localhost/img35.png";
    Writer(product);
}