public static void main(String[] args) {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            File file = new File("D:\\Loic_Workspace\\TestSAX\\res\\test.xml");
            ChannelsHandler handler = new ChannelsHandler();
            parser.parse(file,handler);
            List<Channel> tvGuide = handler.getTVGuide();
            for(Channel c:tvGuide){
                System.out.println(c.getName());
                System.out.println("------------------------");
                for(Programme p:c.getAlProgrammes()){
                    System.out.println(p.getTitle());
                    System.out.println(p.getStart_time()+" - "+p.getEnd_time());
                    System.out.println(p.getGenres());
                    System.out.println("Season : "+p.getSeason()+" / Episode : "+p.getEpisode());
                    System.out.println("Description:\n"+p.getDescription());
                    System.out.println("**********************");
                }

                System.out.println("//////////////////////////");

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

    }