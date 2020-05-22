try {
        context = JAXBContext.newInstance(EmployeeData.class,Employee.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(data, outStream);
    } catch (JAXBException e) {

        e.printStackTrace();
    }