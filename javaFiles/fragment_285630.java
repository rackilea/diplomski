public class Main {

    public static void main(String[] args) {

        Client c = new Client();
        c.setId(1);;
        c.setNom("Zack");


        Facture f = new Facture();
        f.setNum_fact(1);
        f.setC(c);
        c.setF(f);


//        Facture f = new Facture();
//        f.setNum_fact(1);       
//        //c une étape importante
//        c.setF(f);
//
//        f.setC(c);



        SessionFactory s = new AnnotationConfiguration().configure().buildSessionFactory();
        Session ss = s.openSession();
        ss.beginTransaction();
        ss.save(c);
        ss.save(f);

        ss.getTransaction().commit();
        ss.close();
        s.close();


    }

}