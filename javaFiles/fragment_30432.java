public static String getXmlMessage(SOAPMessage message) throws Exception
   {
         ByteArrayOutputStream os = new ByteArrayOutputStream();
         message.writeTo(os);
         final String encoding = (String) message.getProperty(SOAPMessage.CHARACTER_SET_ENCODING);
         if (encoding == null)
         {
             return new String(os.toByteArray());
         }
         else
         {
            return new String(os.toByteArray(), encoding);    
         }
   }