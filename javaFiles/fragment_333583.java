public class MyMain {

    /**
     * @param args
     */
    public static void main(String[] args) {


        ArrayList<Channel> alChannels = XMLManager.getAlChannels();
        for(Channel c:alChannels){
            System.out.println(c.getName());
            System.out.println(c.getOid());
            System.out.println("------------------------");
            for(Programme p:c.getAlProgrammes()){
                System.out.println(p.getTitle());
                System.out.println(p.getStart_time()+" - "+p.getEnd_time());
                System.out.println(p.getGenres());
                System.out.println("Season : "+p.getSeason()+" / Episode : "+p.getEpisode());
                System.out.println("Description:\n"+p.getDescription());
                System.out.println(p.getOid());
                System.out.println("**********************");
            }

            System.out.println("//////////////////////////");

        }

    }

}