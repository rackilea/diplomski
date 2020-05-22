AttitudeListener alti = new AttitudeListenerImpl();
alti.attitudeUpdated(1.0f,1.0f,1.0f,1);
ardrone.addAttitudeUpdateListener(alti);

@Override
public void onIrEvent(IREvent e) 
{
        // TODO Auto-generated method stub
        //to get the altitude:
         System.out.println("altitude : " + alti.getAltitude()); 

}