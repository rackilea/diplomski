public class CustomParticipantStatusListner extends DefaultParticipantStatusListener 
    {

        public void joined(String participant) 
        {
            System.out.println(participant + "just joined MUC");
//actions (add occupantsRightNow)
        }

        public void left(String participant)
        {
            System.out.println(participant + " just left MUC");
//actions (remove occupantsRightNow)
        }
    }