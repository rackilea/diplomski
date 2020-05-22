List<Node> list2 = e.selectNodes("//*[name() = 'Country']");
                        for(Node n1: list2)
                        {
                            Element element2 = (Element) n1;
                            String a1 = element2.attributeValue("isoCountryCode");
                            System.out.println("CC"+a1);
                        }