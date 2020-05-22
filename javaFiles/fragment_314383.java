final String ORDER_XML = "C:\\test\\Order.xml";

    JAXBContext context = JAXBContext.newInstance(Order.class);
    Marshaller m = context.createMarshaller();

    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

    Order o = new Order();

   /* o.setAddress("address1");
    o.setEmailid("email");
    o.setOrderid("orderid");
    o.setOrderStatus("in process");
    o.setPaidStatus("n");
    o.setTotal(250.5);
    o.setUsername("admin");

    o.getMovies().add(new Triplet(1L,2,200.0));
    o.getMovies().add(new Triplet(2L,3,150.0));
    o.getMovies().add(new Triplet(3L,3,400.0));*/
    //o.setMovies(movies);
    m.marshal(o.getObject(), new File(ORDER_XML));