while (existsPhone.hasNext()){
   PhoneNumberMatch phone = existsPhone.next();

   System.out.println("Phone == " + phone.number());
   Log.d("existsPhone",":"+phone.rawString());
   //....
}