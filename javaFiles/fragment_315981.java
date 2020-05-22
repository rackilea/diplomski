public static void main(String[] args) {
        try {
            ListBeans lb = new ListBeans();
            lb.add(new MyBean(1));
            lb.add(new MyBean(2));

            JAXBContext jaxbContext = JAXBContext.newInstance(ListBeans.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(lb, new File("c:\\temp\\mybean.xml"));

        } catch (Exception e) {
        }
        ;

    }

    @XmlRootElement(name = "ROOT")
    public static class ListBeans {

        private List<MyBean> listBeans = null;

        public ListBeans() {

        }
        @XmlElement (name="BEAN")
        public void setListBeans(List<MyBean> listBeans) {
            this.listBeans = listBeans;
        }


        public void add(MyBean mb) {
            if (this.listBeans == null) {
                this.listBeans = new ArrayList<MyBean>();
            }
            this.listBeans.add(mb);
        }


        public static class MyBean {
            private double fxEffectRealized;
            private double changeWPRealized;

            public MyBean() {

            }
            public MyBean(int i) {
              fxEffectRealized = Math.random() * 100;
              changeWPRealized = Math.random() * 100;
            }

            public double getFxEffectRealized() {
              return fxEffectRealized;
            }

            public void setFxEffectRealized(double fxEffectRealized) {
               this.fxEffectRealized = fxEffectRealized;
            }

            public double getChangeWPRealized() {
              return changeWPRealized;
            }

            public void setChangeWPRealized(double changeWPRealized) {
              this.changeWPRealized = changeWPRealized;
            }
        }
     }