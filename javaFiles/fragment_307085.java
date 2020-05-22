public class Request implements Serializable{

     private String id;
     private String name;
     private String hid;

        public String getId()
        {
            return id;
        }

        public String getName()
        {
            return name;
        }

        public String getHid()
        {
            return hid;
        }
}

    public class EmpRequest implements Serializable{
         private Request request;

        public Request getRequest()
        {
            return request;
        }

         @Override 
         public boolean equals(Object obj) {
             if(obj==null)
                 return false;
             if(((EmpRequest) obj).getRequest().getId().equals(this.getRequest().getId()))
                 return true;
             else if(((EmpRequest) obj).getRequest().getName().equals(this.getRequest().getName())
                     &&((EmpRequest) obj).getRequest().getHid().equals(this.getRequest().getHid())) {
                 return true;
             }
             else
                 return false;
         }
    }