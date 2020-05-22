import org.arl.fjage.Message
import org.arl.unet.sim.HalfDuplexModem

class MyHalfDuplexModem extends HalfDuplexModem {

  float energy = 1000   // change to whatever initial energy your node has

  @Override
  boolean send(Message m) {
    if (m instanceof TxFrameNtf) energy -= 10  // change according to your model
    if (m instanceof RxFrameNtf) energy -= 1   // change according to your model
    return super.send(m)
  }

}