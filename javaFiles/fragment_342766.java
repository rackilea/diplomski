[ServiceContract]
    public interface IMessageService{
        [OperationContract(IsOneWay = true)]
        void SendMessage(byte[] msg);
    }

  [ServiceBehavior(InstanceContextMode = InstanceContextMode.Single)]
   public class MessageService: IMessageService{

        public void SendMessage(byte[] msg) {
          //decode the protobuf msg and deal with it.
        }

    }