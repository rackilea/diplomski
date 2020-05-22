// get DOM nodes of paragraph containing target run
// and run itself
Node paragraphNode = paragraph.getCTP().getDomNode();
Node runNode = run.getCTR().getDomNode();

// generate random id for perm region
String id = Integer.toString(this.random.nextInt());

// create starting node, set id and who can edit it
CTPermStart permStart = paragraph.getCTP().addNewPermStart();
permStart.setId(id);
permStart.setEdGrp(STEdGrp.EVERYONE);
Node permStartNode = permStart.getDomNode();

// create ending node and set id
CTPerm permEnd = paragraph.getCTP().addNewPermEnd();
permEnd.setId(id);
Node permEndNode = permEnd.getDomNode();

// enclose target run with created start/end nodes
paragraphNode.insertBefore(permStartNode, runNode);
paragraphNode.insertBefore(permEndNode, runNode.getNextSibling());