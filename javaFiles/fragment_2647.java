public class ComPortConverter implements Converter {

    @Override
    public void marshal(Object o, HierarchicalStreamWriter out, MarshallingContext context) {

        ComPort comPort = (ComPort)o;    

        if (comPort.getPortDirection()== ComPort.PortDirection.Tx){
            out.startNode("sourcePort");
        }else {
            out.startNode("destPort");
        }

        out.addAttribute("id",Integer.toString(comPort.getId()));
        out.addAttribute("name", comPort.getName());

        out.startNode("type");
        out.setValue(comPort.getPortType().name());
        out.endNode();

        out.startNode("maxMessageSize");
        out.setValue(Integer.toString(comPort.getMaxMessageSize()));
        out.endNode();

        out.startNode("characteristic");
        out.setValue(Integer.toString(comPort.getPortCharacteristic()));    
        out.endNode();
        out.close();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader in, UnmarshallingContext context) {

        ComPort result;
        ComPort.PortDirection direction=null;

        if (in.getNodeName().equals("sourcePort")){
            direction = ComPort.PortDirection.Tx;
        }else if (in.getNodeName().equals("destPort")){
            direction = ComPort.PortDirection.Rx;
        }
        int id = Integer.parseInt(in.getAttribute("id"));
        String name = in.getAttribute("name");

        in.moveDown();
        if (in.getValue().equals("Sampling")) result = new SamplingPort(id,name);
        else if(in.getValue().equals("Queuing")) result = new QueuingPort(id,name);
        else throw new IllegalArgumentException("Illegal port type value");
        result.setPortDirection(direction);
        in.moveUp();
        in.moveDown();
        result.setMaxMessageSize(Integer.parseInt(in.getValue()));
        in.moveUp();
        in.moveDown();
        result.setPortCharacteristic(Integer.parseInt(in.getValue()));
        in.moveUp();

        return result;
    }

    @Override
    public boolean canConvert(Class type) {
        return ComPort.class.isAssignableFrom(type);
    }
}