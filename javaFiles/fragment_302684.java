DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();

Document tournament = builder.parse(new File("b.xml"));
Document tournaments = builder.parse(new File("a.xml"));

Node tournamentElement = tournament.getFirstChild();
Node ndetournament = tournaments.getDocumentElement();
Node firstDocImportedNode = tournaments.adoptNode(tournamentElement);
ndetournament.appendChild(firstDocImportedNode);

TransformerFactory transformerFactory = TransformerFactory.newInstance();
Transformer transformer = transformerFactory.newTransformer();
transformer.setOutputProperty(OutputKeys.INDENT, "yes");
transformer.transform(new DOMSource(tournaments), new StreamResult(System.out));