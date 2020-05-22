@Root(name = "Envelope")
@Namespace(prefix = "soap")
// Set the converter that's used for serialization
@Convert(value = SOAPEnvelope.SOAPEnvelopeConverter.class)
public class SOAPEnvelope
{
    // Keep the content of vehicles list here
    private Vehicles vehicles;


    public Vehicles getVehicles()
    {
        return vehicles;
    }

    protected void setVehicles(Vehicles vehicles)
    {
        this.vehicles = vehicles;
    }



    // The converter implementation for SOAPEnvelope
    public static class SOAPEnvelopeConverter implements Converter<SOAPEnvelope>
    {
        @Override
        public SOAPEnvelope read(InputNode node) throws Exception
        {
            SOAPEnvelope envelope = new SOAPEnvelope();
            InputNode vehiclesNode = findVehiclesNode(node); // Search the Vehicles list element

            if( vehiclesNode == null )
            {
                // This is bad - do something useful here
                throw new Exception("No vehicles node!");
            }

            /*
             * A default serializer is used to deserialize the full node. The
             * returned object is set into the envelops's object, where you can
             * get it through a get()-method.
             */
            Serializer ser = new Persister();
            envelope.setVehicles(ser.read(Vehicles.class, vehiclesNode));

            return envelope;
        }


        @Override
        public void write(OutputNode node, SOAPEnvelope value) throws Exception
        {
            // If you read (deserialize) only there's no need to implement this
            throw new UnsupportedOperationException("Not supported yet.");
        }


        private InputNode findVehiclesNode(InputNode rootNode) throws Exception
        {
            InputNode body = rootNode.getNext("Body");
            InputNode buslocationResponse = body.getNext("BuslocationResponse");

            InputNode next;

            while( ( next = buslocationResponse.getNext() ) != null )
            {
                if( next.getName().equals("Vehicles") == true )
                {
                    return next;
                }
            }

            return null;
        }
    }
}