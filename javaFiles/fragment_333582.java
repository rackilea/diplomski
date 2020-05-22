public final class XMLManager {

    public static ArrayList<Channel> getAlChannels(){

          DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
          DocumentBuilder db = null;
          Document doc = null;
          ArrayList<Channel> alChannels = new ArrayList<>();

          try {

            db = dbf.newDocumentBuilder();
            doc = db.parse(new File("D:\\Loic_Workspace\\Test2\\res\\test.xml"));
            NodeList ndListChannels = doc.getElementsByTagName("channel");

            Integer channelsCount = ndListChannels.getLength();
            NodeList ndListChannel = null;
            Integer ndListChannelLength = null;
            Channel channel = null;
            NodeList ndListProgrammes = null;
            for(int i=0;i<channelsCount;i++){

                ndListChannel = ndListChannels.item(i).getChildNodes();
                ndListChannelLength = ndListChannel.getLength();
                channel = new Channel();
                for(int j=0;j<ndListChannelLength;j++){

                    Node currentNode = ndListChannel.item(j);
                    String currentNodeName = currentNode.getNodeName();
                    String value = currentNode.getTextContent();

                    if(currentNodeName.equals("name")){
                        channel.setName(value);
                    }
                    if(currentNodeName.equals("oid")){
                        channel.setOid(value);
                    }
                    if(currentNodeName.equals("programmes")){
                        ndListProgrammes = currentNode.getChildNodes();
                        ArrayList<Programme> alProgrammes = new ArrayList<>();
                        for(int k=0;k<ndListProgrammes.getLength();k++){

                            Node ndProgrammes = ndListProgrammes.item(k);
                            if(ndProgrammes.hasChildNodes()){

                                NodeList ndListProgramme = ndProgrammes.getChildNodes();
                                Integer ndListProgrammeLength = ndListProgramme.getLength();
                                Programme programme = new Programme();
                                for(int l=0;l<ndListProgrammeLength;l++){

                                    Node  ndProgramme = ndListProgramme.item(l);
                                    String nodeProgrameName = ndProgramme.getNodeName();
                                    String nodeProgrameValue = ndProgramme.getTextContent();
                                    if(nodeProgrameName.equals("description")){
                                        programme.setDescription(nodeProgrameValue);
                                    }
                                    if(nodeProgrameName.equals("end_time")){

                                        programme.setEnd_time(nodeProgrameValue);
                                    }
                                    if(nodeProgrameName.equals("episode")){
                                        programme.setEpisode(nodeProgrameValue);
                                    }
                                    if(nodeProgrameName.equals("genres")){
                                        programme.setGenres(nodeProgrameValue);
                                    }
                                    if(nodeProgrameName.equals("oid")){
                                        programme.setOid(nodeProgrameValue);
                                    }
                                    if(nodeProgrameName.equals("season")){
                                        programme.setSeason(nodeProgrameValue);
                                    }
                                    if(nodeProgrameName.equals("start_time")){
                                        programme.setStart_time(nodeProgrameValue);
                                    }
                                    if(nodeProgrameName.equals("title")){
                                        programme.setTitle(nodeProgrameValue);
                                    }

                                }

                                alProgrammes.add(programme);

                            }

                        }

                        channel.setAlProgrammes(alProgrammes);

                    }

                }

                alChannels.add(channel);

            }



          } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

          return alChannels;

    }



}