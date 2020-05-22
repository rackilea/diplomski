import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(DefaultSettings.class, Groups.class, Instruments.class);

        Groups groups1 = new Groups();
        groups1.getInstruments().add(new Instruments());
        groups1.getInstruments().add(new Instruments());

        Groups groups2 = new Groups();
        groups2.getInstruments().add(new Instruments());
        groups2.getInstruments().add(new Instruments());

        DefaultSettings ds = new DefaultSettings();
        ds.getGroups().add(groups1);
        ds.getGroups().add(groups2);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        GroupsAdapter groupsAdapter = new GroupsAdapter();
        marshaller.setAdapter(groupsAdapter);
        marshaller.setAdapter(groupsAdapter.getInstrumentsAdapter());
        marshaller.marshal(ds, System.out);
    }

}