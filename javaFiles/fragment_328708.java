Marshaller marshaller = context.createMarshaller();
ABeanAdapterList adapterList = new ABeanAdapterList();
marshaller.setAdapter(adapterList);
ABeanAdapterImpl beanAdapter = new ABeanAdapterImpl(adapterList);
marshaller.setAdapter(beanAdapter);
marshaller.marshal(sBean, new File("testSBean.xml"));