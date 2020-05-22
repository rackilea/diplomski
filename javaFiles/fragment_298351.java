class MyEventMarshaller
{
    private boolean doStuff = true;
    private Map<String, List<BinaryFunction> > callbackMap = new HashMap<String, List<BinaryFunction>>();

    public void subscribeMessage(String eventKey, BinaryFunction callBack)
    {
        if (!callbackMap.containsKey(eventKey)) {
            callbackMap.put(eventKey, new ArrayList<BinaryFunction>());
        }

        callbackMap.get(eventKey).add(callBack);
    }

    public void marshallLoop()
    {
        while(doStuff)
        {
            //Something interesting happens
            String eventKey = getInterestingEventKey();

            if (callbackMap.containsKey(eventKey))
            {
                for (BinaryFunction cb : callbackMap.get(eventKey))
                {
                    System.out.println("Debug: " + cb.invoke(getDataOne(), getDataTwo()));
                }
            }

            break;
        }
    }

    private Object getDataTwo() { return null; } // TODO Auto-generated method stub
    private Object getDataOne() { return null; } // TODO Auto-generated method stub

    String getInterestingEventKey() { return "yep"; }

}