List e =  em.createNamedQuery("findbybez").setParameter("bez", name).getResultList();
Weterstation w = new Weterstation();

if (e.get(0) != null) {               // <--- Here
    w = (Weterstation) e.get(0);
}

return w;