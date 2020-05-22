private Map<String, Integer> months = ...;

@XmlAnyElement
public List<JAXBElement<Integer>> getMonths() {
    List<JAXBElement<Integer>> elements = new ArrayList<JAXBElement<Integer>>();
    for (Map.Entry<String, Integer> month: months.entrySet()) 
        elements.add(new JAXBElement(new QName(month.getKey()), 
                                     Integer.class, month.getValue()));
    return elements;
}