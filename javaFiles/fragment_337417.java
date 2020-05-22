JAXBContext jc = JAXBContext.newInstance(RootElement.class, A.class, B.class, C.class, D.class, E.class);
Unmarshaller unmarsh = jc.createUnmarshaller();
XMLStreamReader xs = XMLInputFactory.newInstance().createXMLStreamReader(new StringReader(etalonRs));
XMLStreamReader xd = new StreamReaderDelegate(xs) {
      public static final String ROOT_ELEMENT = "TestRoot";
      public static final int REPLACEABLE_LEVEL = 2;
      public final Collection<String> sufficesToDelete = Arrays.asList("Rq", "Rs");

      protected Stack<String> elementNamesStack = new Stack<>();
      protected Set<String> replaceableNames = new HashSet<>();

      @Override
      public String getLocalName() {
          String realName = super.getLocalName();
          if (replaceableNames.contains(realName) && elementNamesStack.size() == REPLACEABLE_LEVEL) {
              for (String suffix : sufficesToDelete) {
                  if (realName.endsWith(suffix)) {
                      return realName.substring(0, realName.lastIndexOf(suffix));
                  }
              }
          }
          return realName;
      }

      @Override
      public int next() throws XMLStreamException {
          final int eventCode = super.next();
         processLevel(eventCode);
          return eventCode;
      }

      @Override
      public int nextTag() throws XMLStreamException {
          final int eventCode = super.nextTag();
          processLevel(eventCode);
          return eventCode;
      }

      private void processLevel(int eventCode) {
          switch (eventCode) {
              case XMLStreamReader.START_ELEMENT:
                  final String origElementName = super.getLocalName();
                  if ((elementNamesStack.size() + 1) == REPLACEABLE_LEVEL && elementNamesStack.peek().equals(ROOT_ELEMENT))
                      replaceableNames.add(origElementName);
                  elementNamesStack.push(origElementName);
                  break;
              case XMLStreamReader.END_ELEMENT: 
                  assert(elementNamesStack.pop().equals(super.getLocalName()));
                  break;

          }
      }
  };

Object o = unmarsh.unmarshal(xd);