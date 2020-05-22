public class ChannelsHandler extends DefaultHandler{

    private ArrayList<Channel> tvGuide;
    private Channel channel;
    private ArrayList<Programme> alProgrammes;
    private Programme programme;
    private String reading;

    public ChannelsHandler(){
        super();
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {

        if(qName.equals("channels")){
            tvGuide = new ArrayList<>();
        }else if(qName.equals("channel")){
            channel = new Channel();
        }
        else if(qName.equals("channel")){
            channel = new Channel();
        }
        else if(qName.equals("programmes")){
            alProgrammes = new ArrayList<>();
        }
        else if(qName.equals("programme")){
            programme = new Programme();
        }

    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        reading = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        if(qName.equals("channel")){
            tvGuide.add(channel);
            channel = null;
        }
        if(qName.equals("name")){
            channel.setName(reading);
        }
        else if(qName.equals("programmes")){
            channel.setAlProgrammes(alProgrammes);
            alProgrammes = new ArrayList<>();
        }
        else if(qName.equals("programme")){
            alProgrammes.add(programme);
            programme = null;
        }
        else if(qName.equals("description")){
            programme.setDescription(reading);
        }
        else if(qName.equals("end_time")){
            programme.setEnd_time(reading);
        }
        else if(qName.equals("episode")){
            programme.setEpisode(reading);
        }
        else if(qName.equals("genres")){
            programme.setGenres(reading);
        }
        else if(qName.equals("season")){
            programme.setSeason(reading);
        }
        else if(qName.equals("start_time")){
            programme.setStart_time(reading);
        }
        else if(qName.equals("title")){
            programme.setTitle(reading);
        }

    }

    public ArrayList<Channel> getTVGuide(){
        return tvGuide;
    }



}